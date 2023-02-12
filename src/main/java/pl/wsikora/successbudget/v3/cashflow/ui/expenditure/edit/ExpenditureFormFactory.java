package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureDto;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureQuery;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;

import java.util.Optional;


@Service
class ExpenditureFormFactory {

    private final ExpenditureQuery expenditureQuery;

    private ExpenditureFormFactory(ExpenditureQuery expenditureQuery) {

        this.expenditureQuery = expenditureQuery;
    }

    ExpenditureForm getExpenditureForm(Long cashFlowId, @Nullable Long expenditureId) {

        Assert.notNull(cashFlowId, "cashFlowId must not be null");

        return Optional.ofNullable(expenditureId)
            .flatMap(expenditureQuery::findByExpenditureId)
            .map(this::toForm)
            .orElseGet(() -> newForm(cashFlowId));
    }

    private ExpenditureForm toForm(ExpenditureDto expenditureDto) {

        MoneyDto moneyDto = expenditureDto.getMoneyDto();

        Money money = moneyDto.getMoney();

        return ExpenditureForm.builder()
            .expenditureId(expenditureDto.getExpenditureId())
            .cashFlowId(expenditureDto.getCashFlowId())
            .title(expenditureDto.getTitle())
            .categoryId(expenditureDto.getCategoryDto().getCategoryId())
            .currency(money.getCurrency().ordinal())
            .value(money.getValue())
            .priority(expenditureDto.getPriority())
            .payee(expenditureDto.getPayee())
            .date(expenditureDto.getDate())
            .repeatInNextPeriod(expenditureDto.isRepeatInNextPeriod())
            .build();
    }

    private ExpenditureForm newForm(Long cashFlowId) {

        return ExpenditureForm.builder()
            .cashFlowId(cashFlowId)
            .build();
    }

}
