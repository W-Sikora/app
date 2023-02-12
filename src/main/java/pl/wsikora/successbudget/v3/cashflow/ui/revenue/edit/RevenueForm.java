package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import lombok.*;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueAttributes;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
class RevenueForm implements RevenueAttributes {

    private Long revenueId;
    private Long cashFlowId;
    private String title;
    private Long categoryId;
    private String date;
    private Integer currency;
    private BigDecimal value;
    private String payer;
    private boolean repeatInNextPeriod;

}
