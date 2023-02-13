package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;
import pl.wsikora.successbudget.v3.user.application.RegistrationCommand;
import pl.wsikora.successbudget.v3.user.domain.Password;
import pl.wsikora.successbudget.v3.user.domain.User;


@Service
class RegistrationCommandImpl implements RegistrationCommand {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private RegistrationCommandImpl(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder
    ) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(RegistrationAttributes registrationAttributes) {

        Assert.notNull(registrationAttributes, "registrationAttributes must not be null");

        Username username = Username.of(registrationAttributes.getUsername());

        Password password = Password.of(registrationAttributes.getPassword());

        String encode = passwordEncoder.encode(password.getValue());

        Password encodedPassword = Password.encoded(encode);

        User user = new User(username, encodedPassword, null);

        userRepository.save(user);
    }

}
