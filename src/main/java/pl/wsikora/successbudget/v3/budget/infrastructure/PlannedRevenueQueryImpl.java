package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueDto;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueQuery;
import pl.wsikora.successbudget.v3.budget.domain.PlannedRevenue;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDtoFactory;

import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_REVENUE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_REVENUE_EDIT_PATH;


@Service
class PlannedRevenueQueryImpl implements PlannedRevenueQuery {

    private final PlannedRevenueRepository plannedRevenueRepository;
    private final CategoryDtoProvider categoryDtoProvider;

    private PlannedRevenueQueryImpl(PlannedRevenueRepository plannedRevenueRepository,
                                    CategoryDtoProvider categoryDtoProvider) {

        this.plannedRevenueRepository = plannedRevenueRepository;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    @Override
    public Optional<PlannedRevenueDto> findByPlannedRevenueId(Long plannedRevenueId) {

        Assert.notNull(plannedRevenueId, "plannedRevenueId must not be null");

        return plannedRevenueRepository.findByPlannedRevenueId(plannedRevenueId)
            .map(this::toDto);
    }

    @Override
    public Page<PlannedRevenueDto> findAll(Pageable pageable, Long budgetId) {

        Assert.notNull(pageable, "pageable must not be null");
        Assert.notNull(budgetId, "budgetId must not be null");

        return plannedRevenueRepository.findAll(pageable, budgetId)
            .map(this::toDto);
    }

    @Override
    public boolean hasAssignedCategory(Long budgetId, Long categoryId) {

        Assert.notNull(budgetId, "budgetId must not be null");
        Assert.notNull(categoryId, "categoryId must not be null");

        return plannedRevenueRepository.hasAssignedCategory(budgetId, categoryId);
    }

    private PlannedRevenueDto toDto(PlannedRevenue plannedRevenue) {

        CategoryDto categoryDto = categoryDtoProvider.convert(plannedRevenue.getCategoryId());

        MoneyDto moneyDto = MoneyDtoFactory.create(plannedRevenue.getMoney());

        Long budgetId = plannedRevenue.getBudget().getBudgetId();

        Long plannedRevenueId = plannedRevenue.getPlannedRevenueId();

        UrlDto urlDto = UrlDtoFactory.create(PLANNED_REVENUE_EDIT_PATH, PLANNED_REVENUE_DELETE_PATH,
            budgetId, plannedRevenueId);

        return new PlannedRevenueDto(
            plannedRevenueId,
            budgetId,
            categoryDto,
            moneyDto,
            plannedRevenue.isRepeatInNextPeriod(),
            urlDto
        );
    }

}
