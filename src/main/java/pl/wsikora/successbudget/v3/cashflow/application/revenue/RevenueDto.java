package pl.wsikora.successbudget.v3.cashflow.application.revenue;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;


@Value
public class RevenueDto {

    Long revenueId;
    Long cashFlowId;
    String title;
    CategoryDto categoryDto;
    MoneyDto moneyDto;
    String payer;
    String date;
    boolean repeatInNextPeriod;
    UrlDto urlDto;

}
