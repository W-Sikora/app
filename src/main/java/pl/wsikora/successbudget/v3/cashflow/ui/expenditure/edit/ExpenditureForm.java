package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
public class ExpenditureForm {

    private Long expenditureId;
    private Long cashFlowId;
    private String title;
    private String description;
    private Long categoryId;
    private BigDecimal value;
    private Integer currencyId;
    private Integer priorityId;
    private String payee;
    private Integer scheduleId;
    private LocalDate date;

}
