package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureDto;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureQuery;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyConverter;

import java.time.YearMonth;
import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;


@Service
class PlannedExpenditureFormFactory {

    private final PlannedExpenditureQuery plannedExpenditureQuery;

    private PlannedExpenditureFormFactory(PlannedExpenditureQuery plannedExpenditureQuery) {

        this.plannedExpenditureQuery = plannedExpenditureQuery;
    }

    PlannedExpenditureForm createPlannedExpenditureForm(@Nullable Long plannedExpenditureId, YearMonth period) {

        Assert.notNull(period, "period must not be null");

        return Optional.ofNullable(plannedExpenditureId)
            .flatMap(plannedExpenditureQuery::findByPlannedExpenditureId)
            .map(this::toForm)
            .orElseGet(() -> newForm(period));
    }

    private PlannedExpenditureForm toForm(PlannedExpenditureDto plannedExpenditureDto) {

        Money money = MoneyConverter.convert(plannedExpenditureDto.getMoneyDto());

        return PlannedExpenditureForm.builder()
            .plannedExpenditureId(plannedExpenditureDto.getPlannedExpenditureId())
            .period(YearMonth.parse(plannedExpenditureDto.getPeriod(), PERIOD_FORMATTER))
            .categoryId(plannedExpenditureDto.getCategoryDto().getCategoryId())
            .priority(plannedExpenditureDto.getPriority())
            .currency(money.getCurrency().ordinal())
            .value(money.getValue())
            .repeatInNextPeriod(plannedExpenditureDto.isRepeatInNextPeriod())
            .build();
    }

    private PlannedExpenditureForm newForm(YearMonth period) {

        return PlannedExpenditureForm.builder()
            .period(period)
            .build();
    }

}
