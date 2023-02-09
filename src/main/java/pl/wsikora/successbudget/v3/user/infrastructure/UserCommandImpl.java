package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.exception.NotFoundException;
import pl.wsikora.successbudget.v3.common.type.Currency;
import pl.wsikora.successbudget.v3.common.username.Username;
import pl.wsikora.successbudget.v3.common.username.UsernameProvider;
import pl.wsikora.successbudget.v3.user.application.MajorCurrencyAttributes;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;
import pl.wsikora.successbudget.v3.user.application.UserCommand;
import pl.wsikora.successbudget.v3.user.application.UserPasswordEncoder;
import pl.wsikora.successbudget.v3.user.domain.Password;
import pl.wsikora.successbudget.v3.user.domain.User;


@Service
class UserCommandImpl implements UserCommand {

    private final UserRepository userRepository;
    private final UserPasswordEncoder userPasswordEncoder;
    private final UsernameProvider usernameProvider;

    private UserCommandImpl(UserRepository userRepository,
                            UserPasswordEncoder userPasswordEncoder,
                            UsernameProvider usernameProvider) {

        this.userRepository = userRepository;
        this.userPasswordEncoder = userPasswordEncoder;
        this.usernameProvider = usernameProvider;
    }

    @Override
    public void save(RegistrationAttributes registrationAttributes) {

        Assert.notNull(registrationAttributes, "registrationAttributes must not be null");

        Username username = new Username(registrationAttributes.getUsername());
        Password password = Password.of(registrationAttributes.getPassword());
        Password encodedPassword = userPasswordEncoder.encodePassword(password);

        User user = new User(username, encodedPassword, null);

        userRepository.save(user);
    }

    @Override
    public void save(MajorCurrencyAttributes majorCurrencyAttributes) {

        Assert.notNull(majorCurrencyAttributes, "majorCurrencyAttributes must not be null");

        String username = usernameProvider.getUsername().getValue();

        Currency currency = Currency.getByCurrencyId(majorCurrencyAttributes.getMajorCurrencyId());

        userRepository.findByUsernameAsString(username)
            .map(user -> {
                user.setMajorCurrency(currency);
                return user;
            })
            .map(userRepository::save)
            .orElseThrow(() -> new NotFoundException("User"));
    }

}
