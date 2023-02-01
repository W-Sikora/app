package pl.wsikora.successbudget.v3.cashflow.application;

import lombok.Value;


@Value
public class CashFlowDto {

    Long cashFlowId;
    String title;
    String description;

}
