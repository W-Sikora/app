package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;
import pl.wsikora.successbudget.v3.user.application.MajorCurrencyAttributes;
import pl.wsikora.successbudget.v3.user.application.MajorCurrencyCommand;
import pl.wsikora.successbudget.v3.user.domain.User;


@Service
class MajorCurrencyCommandImpl implements MajorCurrencyCommand {

    private final UserRepository userRepository;
    private final UsernameProvider usernameProvider;

    private MajorCurrencyCommandImpl(
        UserRepository userRepository,
        UsernameProvider usernameProvider
    ) {

        this.userRepository = userRepository;
        this.usernameProvider = usernameProvider;
    }

    @Override
    public void save(MajorCurrencyAttributes majorCurrencyAttributes) {

        Assert.notNull(majorCurrencyAttributes, "majorCurrencyAttributes must not be null");

        String username = usernameProvider.getUsername().getValue();

        Currency currency = Currency.of(majorCurrencyAttributes.getCurrency());

        userRepository.findByUsernameAsString(username)
            .map(user -> assignMajorCurrency(user, currency))
            .map(userRepository::save)
            .orElseThrow(() -> new NotFoundException("User"));
    }

    private User assignMajorCurrency(User user, Currency majorCurrency) {

        user.setMajorCurrency(majorCurrency);

        return user;
    }

}
