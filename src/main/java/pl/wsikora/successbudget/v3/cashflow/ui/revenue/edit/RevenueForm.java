package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import lombok.Getter;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Money;
import pl.wsikora.successbudget.v3.common.type.Payer;
import pl.wsikora.successbudget.v3.common.type.Schedule;

import java.time.LocalDate;


@Getter
@Setter
public class RevenueForm {

    private Long revenueId;
    private Long cashFlowCashFlowId;
    private String titleValue;
    private String descriptionValue;
    private Long categoryCategoryId;
    private Money money;
    private Payer payer;
    private Schedule schedule;
    private LocalDate date;

}
