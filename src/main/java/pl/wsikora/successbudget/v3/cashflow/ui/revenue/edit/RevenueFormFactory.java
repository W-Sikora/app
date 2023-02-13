package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueDto;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueQuery;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyConverter;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.DateFormatter.DATE_FORMATTER;
import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;


@Service
class RevenueFormFactory {

    private final RevenueQuery revenueQuery;

    private RevenueFormFactory(RevenueQuery revenueQuery) {

        this.revenueQuery = revenueQuery;
    }

    RevenueForm getRevenueForm(@Nullable Long revenueId, YearMonth period) {

        Assert.notNull(period, "period must not be null");

        return Optional.ofNullable(revenueId)
            .flatMap(revenueQuery::findByRevenueId)
            .map(this::toForm)
            .orElseGet(() -> newForm(period));
    }

    private RevenueForm toForm(RevenueDto revenueDto) {

        MoneyDto moneyDto = revenueDto.getMoneyDto();

        Money money = MoneyConverter.convert(moneyDto);

        return RevenueForm.builder()
            .revenueId(revenueDto.getRevenueId())
            .period(YearMonth.parse(revenueDto.getPeriod(), PERIOD_FORMATTER))
            .title(revenueDto.getTitle())
            .categoryId(revenueDto.getCategoryDto().getCategoryId())
            .date(LocalDate.parse(revenueDto.getDate(), DATE_FORMATTER))
            .currency(money.getCurrency().ordinal())
            .value(money.getValue())
            .payer(revenueDto.getPayer())
            .repeatInNextPeriod(revenueDto.isRepeatInNextPeriod())
            .build();
    }

    private RevenueForm newForm(YearMonth period) {

        return RevenueForm.builder()
            .period(period)
            .build();
    }

}
