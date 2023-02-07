package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RevenueForm {

    private Long revenueId;
    private Long cashFlowId;
    private String title;
    private String description;
    private Long categoryId;
    private Integer currencyId;
    private BigDecimal value;
    private String payer;
    private String date;

}
