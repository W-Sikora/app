package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueDto;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueQuery;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyConverter;

import java.time.YearMonth;
import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;


@Service
class PlannedRevenueFormFactory {

    private final PlannedRevenueQuery plannedRevenueQuery;

    private PlannedRevenueFormFactory(PlannedRevenueQuery plannedRevenueQuery) {

        this.plannedRevenueQuery = plannedRevenueQuery;
    }

    PlannedRevenueForm getPlannedExpenditureForm(@Nullable Long plannedRevenueId, YearMonth period) {

        Assert.notNull(period, "period must not be null");

        return Optional.ofNullable(plannedRevenueId)
            .flatMap(plannedRevenueQuery::findByPlannedRevenueId)
            .map(this::toForm)
            .orElseGet(() -> newForm(period));
    }

    private PlannedRevenueForm toForm(PlannedRevenueDto plannedRevenueDto) {

        Money money = MoneyConverter.convert(plannedRevenueDto.getMoneyDto());

        return PlannedRevenueForm.builder()
            .plannedRevenueId(plannedRevenueDto.getPlannedRevenueId())
            .period(YearMonth.parse(plannedRevenueDto.getPeriod(), PERIOD_FORMATTER))
            .categoryId(plannedRevenueDto.getCategoryDto().getCategoryId())
            .currency(money.getCurrency().ordinal())
            .value(money.getValue())
            .repeatInNextPeriod(plannedRevenueDto.isRepeatInNextPeriod())
            .build();
    }

    private PlannedRevenueForm newForm(YearMonth period) {

        return PlannedRevenueForm.builder()
            .period(period)
            .build();
    }

}
