package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import lombok.Getter;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Money;

import java.time.LocalDate;


@Getter
@Setter
public class ExpenditureForm {

    private Long expenditureId;
    private Long cashFlowCashFlowId;
    private String title;
    private String description;
    private Long categoryId;
    private Money money;
    private Integer priorityId;
    private String payee;
    private Integer scheduleId;
    private LocalDate date;

}
