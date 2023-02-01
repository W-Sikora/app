package pl.wsikora.successbudget.v3.cashflow.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.Money;
import pl.wsikora.successbudget.v3.common.type.Payee;
import pl.wsikora.successbudget.v3.common.type.Schedule;

import java.time.LocalDate;


@Value
public class ExpenditureDto {

    Long expenditureId;
    String title;
    String description;
    String categoryTitle;
    Money money;
    Payee payee;
    Schedule schedule;
    LocalDate date;

}
