package pl.wsikora.successbudget.v3.common.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
@AllArgsConstructor
public class MoneyForm {

    private Integer currencyId;
    private BigDecimal value;

}
