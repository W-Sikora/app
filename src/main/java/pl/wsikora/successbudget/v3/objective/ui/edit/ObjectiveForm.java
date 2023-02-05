package pl.wsikora.successbudget.v3.objective.ui.edit;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
class ObjectiveForm {

    private Long objectiveId;
    private String title;
    private String description;
    private Long necessaryMoneyCurrency;
    private BigDecimal necessaryMoney;
    private Long raisedMoneyCurrency;
    private BigDecimal raisedMoney;

}
