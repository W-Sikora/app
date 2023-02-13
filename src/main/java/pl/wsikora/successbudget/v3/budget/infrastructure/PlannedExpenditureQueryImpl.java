package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetFilter;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureDto;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureQuery;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDtoFactory;

import java.time.YearMonth;
import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_EXPENDITURE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_EXPENDITURE_EDIT_PATH;
import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;


@Service
class PlannedExpenditureQueryImpl implements PlannedExpenditureQuery {

    private final PlannedExpenditureRepository plannedExpenditureRepository;
    private final CategoryDtoProvider categoryDtoProvider;

    private PlannedExpenditureQueryImpl(
        PlannedExpenditureRepository plannedExpenditureRepository,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.plannedExpenditureRepository = plannedExpenditureRepository;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    @Override
    public Optional<PlannedExpenditureDto> findByPlannedExpenditureId(Long plannedExpenditureId) {

        Assert.notNull(plannedExpenditureId, "revenueId must not be null");

        return plannedExpenditureRepository.findByPlannedExpenditureId(plannedExpenditureId)
            .map(this::toDto);
    }

    @Override
    public Page<PlannedExpenditureDto> findAll(BudgetFilter budgetFilter) {

        Assert.notNull(budgetFilter, "budgetFilter must not be null");

        return plannedExpenditureRepository.findAll(budgetFilter.pageable(),
                budgetFilter.period(), budgetFilter.categoryId())
            .map(this::toDto);
    }

    @Override
    public boolean hasAssignedCategory(YearMonth period, Long categoryId) {

        Assert.notNull(period, "period must not be null");
        Assert.notNull(categoryId, "categoryId must not be null");

        return plannedExpenditureRepository.hasAssignedCategory(period, categoryId);
    }

    private PlannedExpenditureDto toDto(PlannedExpenditure plannedExpenditure) {

        Long plannedExpenditureId = plannedExpenditure.getPlannedExpenditureId();

        CategoryDto categoryDto = categoryDtoProvider.convert(plannedExpenditure.getCategoryId());

        MoneyDto moneyDto = MoneyDtoFactory.create(plannedExpenditure.getMoney());

        UrlDto urlDto = UrlDtoFactory.create(PLANNED_EXPENDITURE_EDIT_PATH,
            PLANNED_EXPENDITURE_DELETE_PATH, plannedExpenditureId);

        return new PlannedExpenditureDto(
            plannedExpenditureId,
            plannedExpenditure.getPeriod().format(PERIOD_FORMATTER),
            categoryDto,
            plannedExpenditure.getPriority().ordinal(),
            moneyDto,
            plannedExpenditure.isRepeatInNextPeriod(),
            urlDto
        );
    }

}
