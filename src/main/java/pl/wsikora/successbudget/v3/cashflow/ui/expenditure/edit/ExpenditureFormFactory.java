package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.cashflow.ExpenditureDto;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureQuery;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyConverter;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;

import java.time.YearMonth;
import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;


@Service
class ExpenditureFormFactory {

    private final ExpenditureQuery expenditureQuery;

    private ExpenditureFormFactory(ExpenditureQuery expenditureQuery) {

        this.expenditureQuery = expenditureQuery;
    }

    ExpenditureForm getExpenditureForm(@Nullable Long expenditureId, YearMonth period) {

        Assert.notNull(period, "period must not be null");

        return Optional.ofNullable(expenditureId)
            .flatMap(expenditureQuery::findByExpenditureId)
            .map(this::toForm)
            .orElseGet(() -> newForm(period));
    }

    private ExpenditureForm toForm(ExpenditureDto expenditureDto) {

        MoneyDto moneyDto = expenditureDto.getMoneyDto();

        Money money = MoneyConverter.convert(moneyDto);

        return ExpenditureForm.builder()
            .expenditureId(expenditureDto.getExpenditureId())
            .period(YearMonth.parse(expenditureDto.getPeriod(), PERIOD_FORMATTER))
            .title(expenditureDto.getTitle())
            .categoryId(expenditureDto.getCategoryDto().getCategoryId())
            .priority(expenditureDto.getPriority())
            .date(expenditureDto.getDate())
            .currency(money.getCurrency().ordinal())
            .value(money.getValue())
            .payee(expenditureDto.getPayee())
            .repeatInNextPeriod(expenditureDto.isRepeatInNextPeriod())
            .build();
    }

    private ExpenditureForm newForm(YearMonth period) {

        return ExpenditureForm.builder()
            .period(period)
            .build();
    }

}
