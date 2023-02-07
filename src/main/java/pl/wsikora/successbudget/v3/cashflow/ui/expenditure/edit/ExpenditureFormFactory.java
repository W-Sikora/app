package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.cashflow.application.ExpenditureDto;
import pl.wsikora.successbudget.v3.cashflow.application.ExpenditureQuery;
import pl.wsikora.successbudget.v3.common.type.application.MoneyDto;


@Service
class ExpenditureFormFactory {

    private final ExpenditureQuery expenditureQuery;

    private ExpenditureFormFactory(ExpenditureQuery expenditureQuery) {

        this.expenditureQuery = expenditureQuery;
    }

    ExpenditureForm getExpenditureForm(Long expenditureId) {

        return expenditureQuery.findByExpenditureId(expenditureId)
            .map(this::toForm)
            .orElseGet(ExpenditureForm::new);
    }

    private ExpenditureForm toForm(ExpenditureDto expenditureDto) {

        MoneyDto moneyDto = expenditureDto.getMoneyDto();

        return ExpenditureForm.builder()
            .expenditureId(expenditureDto.getExpenditureId())
            .cashFlowId(expenditureDto.getCashFlowId())
            .title(expenditureDto.getTitle())
            .categoryId(expenditureDto.getCategoryDto().getCategoryId())
            .currencyId(moneyDto.getCurrencyId())
            .value(moneyDto.getValue())
            .priorityId(expenditureDto.getPriorityId())
            .payee(expenditureDto.getPayee())
            .date(expenditureDto.getDate())
            .build();
    }
}
