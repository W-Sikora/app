package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;
import pl.wsikora.successbudget.v3.user.application.UserCommand;
import pl.wsikora.successbudget.v3.user.domain.Password;
import pl.wsikora.successbudget.v3.user.domain.User;


@Service
class UserCommandImpl implements UserCommand {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private UserCommandImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(RegistrationAttributes registrationAttributes) {

        Username username = new Username(registrationAttributes.getUsername());
        Password password = new Password(passwordEncoder.encode(registrationAttributes.getPassword()));

        User user = new User(username, password);

        userRepository.save(user);
    }
}
