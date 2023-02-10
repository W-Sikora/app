package pl.wsikora.successbudget.v3.common.type.money;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MoneyForm {

    private Integer currencyId;
    private BigDecimal value;

}
