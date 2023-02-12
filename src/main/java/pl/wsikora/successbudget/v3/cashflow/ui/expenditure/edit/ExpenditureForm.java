package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import lombok.*;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureAttributes;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
class ExpenditureForm implements ExpenditureAttributes {

    private Long expenditureId;
    private Long cashFlowId;
    private String title;
    private Long categoryId;
    private Integer priority;
    private String date;
    private Integer currency;
    private BigDecimal value;
    private String payee;
    private boolean repeatInNextPeriod;

}
