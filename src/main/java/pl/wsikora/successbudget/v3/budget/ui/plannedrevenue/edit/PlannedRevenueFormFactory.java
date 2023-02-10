package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueDto;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueQuery;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;

import java.util.Optional;


@Service
class PlannedRevenueFormFactory {

    private final PlannedRevenueQuery plannedRevenueQuery;

    private PlannedRevenueFormFactory(PlannedRevenueQuery plannedRevenueQuery) {

        this.plannedRevenueQuery = plannedRevenueQuery;
    }

    PlannedRevenueForm getPlannedExpenditureForm(Long budgetId, @Nullable Long plannedExpenditureId) {

        Assert.notNull(budgetId, "budgetId must not be null");

        return Optional.ofNullable(plannedExpenditureId)
            .flatMap(plannedRevenueQuery::findByPlannedRevenueId)
            .map(this::toForm)
            .orElseGet(() -> newForm(budgetId));
    }

    private PlannedRevenueForm toForm(PlannedRevenueDto plannedRevenueDto) {

        MoneyDto moneyDto = plannedRevenueDto.getMoneyDto();

        return PlannedRevenueForm.builder()
            .plannedRevenueId(plannedRevenueDto.getPlannedRevenueId())
            .budgetId(plannedRevenueDto.getBudgetId())
            .categoryId(plannedRevenueDto.getCategoryDto().getCategoryId())
            .currency(moneyDto.getCurrencyId())
            .value(moneyDto.getValue())
            .repeatInNextPeriod(plannedRevenueDto.isRepeatInNextPeriod())
            .build();
    }

    private PlannedRevenueForm newForm(Long budgetId) {

        return PlannedRevenueForm.builder()
            .budgetId(budgetId)
            .build();
    }

}
