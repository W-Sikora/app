package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureDto;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureQuery;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDtoFactory;

import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_EXPENDITURE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_EXPENDITURE_EDIT_PATH;


@Service
class PlannedExpenditureQueryImpl implements PlannedExpenditureQuery {

    private final PlannedExpenditureRepository plannedExpenditureRepository;
    private final CategoryDtoProvider categoryDtoProvider;

    private PlannedExpenditureQueryImpl(PlannedExpenditureRepository plannedExpenditureRepository,
                                        CategoryDtoProvider categoryDtoProvider) {

        this.plannedExpenditureRepository = plannedExpenditureRepository;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    @Override
    public Optional<PlannedExpenditureDto> findByPlannedExpenditureId(Long plannedExpenditureId) {

        Assert.notNull(plannedExpenditureId, "plannedExpenditureId must not be null");

        return plannedExpenditureRepository.findByPlannedExpenditureId(plannedExpenditureId)
            .map(this::toDto);
    }

    @Override
    public Page<PlannedExpenditureDto> findAll(Pageable pageable, Long budgetId) {

        Assert.notNull(pageable, "pageable must not be null");
        Assert.notNull(budgetId, "budgetId must not be null");

        return plannedExpenditureRepository.findAll(pageable, budgetId)
            .map(this::toDto);
    }

    private PlannedExpenditureDto toDto(PlannedExpenditure plannedExpenditure) {

        CategoryDto categoryDto = categoryDtoProvider.convert(plannedExpenditure.getCategoryId());

        MoneyDto moneyDto = MoneyDtoFactory.create(plannedExpenditure.getMoney());

        Long plannedExpenditureId = plannedExpenditure.getPlannedExpenditureId();

        Long budgetId = plannedExpenditure.getBudget().getBudgetId();

        UrlDto urlDto = UrlDtoFactory.create(PLANNED_EXPENDITURE_EDIT_PATH, PLANNED_EXPENDITURE_DELETE_PATH,
            budgetId, plannedExpenditureId);

        return new PlannedExpenditureDto(
            plannedExpenditureId,
            budgetId,
            categoryDto,
            plannedExpenditure.getPriority().ordinal(),
            moneyDto,
            plannedExpenditure.isRepeatInNextPeriod(),
            urlDto
        );
    }

}
