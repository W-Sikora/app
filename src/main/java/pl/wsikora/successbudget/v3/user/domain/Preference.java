package pl.wsikora.successbudget.v3.user.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsikora.successbudget.v3.common.type.Currency;


@Getter
@NoArgsConstructor
@Embeddable
public class Preference {

    private CurrencyPresentationMethod currencyPresentationMethod;
    private Currency mainCurrency;
}
