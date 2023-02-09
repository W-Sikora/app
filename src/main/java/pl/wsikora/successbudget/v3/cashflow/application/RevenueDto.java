package pl.wsikora.successbudget.v3.cashflow.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.money.MoneyDto;


@Value
public class RevenueDto {

    Long revenueId;
    Long cashFlowId;
    String title;
    String description;
    CategoryDto categoryDto;
    MoneyDto moneyDto;
    String payer;
    String date;

}
