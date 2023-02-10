package pl.wsikora.successbudget.v3.cashflow.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;


@Value
public class ExpenditureDto {

    Long expenditureId;
    Long cashFlowId;
    String title;
    CategoryDto categoryDto;
    MoneyDto moneyDto;
    Integer priorityId;
    String payee;
    String date;

}
