package pl.wsikora.successbudget.v3.objective.ui.edit;

import lombok.*;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveAttributes;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
class ObjectiveForm implements ObjectiveAttributes {

    private Long objectiveId;
    private String title;
    private String description;
    private Integer necessaryMoneyCurrencyId;
    private BigDecimal necessaryMoneyValue;
    private boolean realized;

}
