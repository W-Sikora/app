package pl.wsikora.successbudget.v3.cashflow.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.Money;

import java.time.LocalDate;


@Value
public class RevenueDto {

    Long revenueId;
    String title;
    String description;
    String categoryTitle;
    Money money;
    String payer;
    Integer scheduleId;
    LocalDate date;

}
