package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;


@Value
public class ExpenditureDto {

    Long expenditureId;
    String period;
    String title;
    CategoryDto categoryDto;
    Integer priority;
    String date;
    MoneyDto moneyDto;
    String payee;
    boolean repeatInNextPeriod;
    UrlDto urlDto;

}
