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
import pl.wsikora.successbudget.v3.common.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.money.MoneyDtoConverter;

import java.util.Optional;


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
    public Page<PlannedExpenditureDto> findAll(Pageable pageable) {

        Assert.notNull(pageable, "pageable must not be null");

        return plannedExpenditureRepository.findAll(pageable)
            .map(this::toDto);
    }

    @Override
    public boolean hasRepeatable(Long budgetId) {

        Assert.notNull(budgetId, "budgetId must not be null");

        return plannedExpenditureRepository.hasRepeatableByBudgetId(budgetId);
    }

    private PlannedExpenditureDto toDto(PlannedExpenditure plannedExpenditure) {

        CategoryDto categoryDto = categoryDtoProvider.convert(plannedExpenditure.getCategoryId());

        MoneyDto moneyDto = MoneyDtoConverter.convert(plannedExpenditure.getMoney());

        return new PlannedExpenditureDto(
            plannedExpenditure.getPlannedExpenditureId(),
            plannedExpenditure.getBudget().getBudgetId(),
            categoryDto,
            plannedExpenditure.getPriority().ordinal(),
            moneyDto,
            plannedExpenditure.isRepeatInNextPeriod()
        );
    }

}
