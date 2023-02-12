package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.currency.MajorCurrencyProvider;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;

import java.util.Optional;


@Service
class MajorCurrencyProviderImpl implements MajorCurrencyProvider {

    private static final Currency DEFAULT_CURRENCY = Currency.POLISH_ZLOTY;

    private final UserRepository userRepository;
    private final UsernameProvider usernameProvider;

    private MajorCurrencyProviderImpl(
        UserRepository userRepository,
        UsernameProvider usernameProvider
    ) {

        this.userRepository = userRepository;
        this.usernameProvider = usernameProvider;
    }

    @Override
    public Currency getMajorCurrencyOrDefault() {

        return Optional.ofNullable(getMajorCurrency())
                .orElse(DEFAULT_CURRENCY);
    }

    @Override
    public Currency getMajorCurrency() {

        Username username = usernameProvider.getUsername();

        return userRepository.findMajorCurrency(username)
            .map(Currency::of)
            .orElse(null);
    }

}
