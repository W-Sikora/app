package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
class ExpenditureForm {

    private Long expenditureId;
    private Long cashFlowId;
    private String title;
    private Long categoryId;
    private Integer currencyId;
    private BigDecimal value;
    private Integer priorityId;
    private String payee;
    private String date;

}
