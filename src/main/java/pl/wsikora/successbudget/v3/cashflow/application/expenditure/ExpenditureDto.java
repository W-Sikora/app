package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import lombok.Value;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;


@Value
public class ExpenditureDto {

    Long expenditureId;
    Long cashFlowId;
    String title;
    CategoryDto categoryDto;
    MoneyDto moneyDto;
    Integer priority;
    String payee;
    String date;
    boolean repeatInNextPeriod;
    UrlDto urlDto;

}
