package pl.wsikora.successbudget.v3.user.ui.majorcurrency;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.majorcurrency.MajorCurrencyProvider;
import pl.wsikora.successbudget.v3.common.type.Currency;

import java.util.Optional;


@Service
class MajorCurrencyFormFactory {

    private final MajorCurrencyProvider majorCurrencyProvider;

    private MajorCurrencyFormFactory(MajorCurrencyProvider majorCurrencyProvider) {

        this.majorCurrencyProvider = majorCurrencyProvider;
    }

    MajorCurrencyForm getMajorCurrencyForm() {

        return Optional.ofNullable(majorCurrencyProvider.getMajorCurrency())
            .map(this::toForm)
            .orElseGet(MajorCurrencyForm::new);
    }

    private MajorCurrencyForm toForm(Currency currency) {

        return new MajorCurrencyForm(currency.ordinal());
    }

}
