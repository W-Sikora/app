package pl.wsikora.successbudget.v3.cashflow.application.revenue;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;


@Value
public class RevenueDto {

    Long revenueId;
    String period;
    String title;
    CategoryDto categoryDto;
    String date;
    MoneyDto moneyDto;
    String payer;
    boolean repeatInNextPeriod;
    UrlDto urlDto;

}
