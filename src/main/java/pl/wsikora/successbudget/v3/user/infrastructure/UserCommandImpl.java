package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;
import pl.wsikora.successbudget.v3.user.application.MajorCurrencyAttributes;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;
import pl.wsikora.successbudget.v3.user.application.UserCommand;
import pl.wsikora.successbudget.v3.user.domain.Password;
import pl.wsikora.successbudget.v3.user.domain.User;


@Service
class UserCommandImpl implements UserCommand {

    private final UserRepository userRepository;
    private final UsernameProvider usernameProvider;
    private final PasswordEncoder passwordEncoder;

    private UserCommandImpl(UserRepository userRepository,
                            UsernameProvider usernameProvider,
                            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.usernameProvider = usernameProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(RegistrationAttributes registrationAttributes) {

        Assert.notNull(registrationAttributes, "registrationAttributes must not be null");

        Username username = new Username(registrationAttributes.getUsername());

        Password password = Password.of(registrationAttributes.getPassword());

        String encode = passwordEncoder.encode(password.getValue());

        Password encodedPassword = Password.encoded(encode);

        User user = new User(username, encodedPassword, null);

        userRepository.save(user);
    }

    @Override
    public void save(MajorCurrencyAttributes majorCurrencyAttributes) {

        Assert.notNull(majorCurrencyAttributes, "majorCurrencyAttributes must not be null");

        String username = usernameProvider.getUsername().getValue();

        Currency currency = Currency.of(majorCurrencyAttributes.getMajorCurrencyId());

        userRepository.findByUsernameAsString(username)
            .map(user -> {
                user.setMajorCurrency(currency);
                return user;
            })
            .map(userRepository::save)
            .orElseThrow(() -> new NotFoundException("User"));
    }

}
