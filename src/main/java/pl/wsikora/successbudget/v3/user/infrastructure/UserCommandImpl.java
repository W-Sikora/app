package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;
import pl.wsikora.successbudget.v3.user.application.UserCommand;
import pl.wsikora.successbudget.v3.user.application.UserPasswordEncoder;
import pl.wsikora.successbudget.v3.user.domain.Password;
import pl.wsikora.successbudget.v3.user.domain.User;


@Service
class UserCommandImpl implements UserCommand {

    private final UserRepository userRepository;
    private final UserPasswordEncoder userPasswordEncoder;

    private UserCommandImpl(UserRepository userRepository, UserPasswordEncoder userPasswordEncoder) {

        this.userRepository = userRepository;
        this.userPasswordEncoder = userPasswordEncoder;
    }

    @Override
    public void save(RegistrationAttributes registrationAttributes) {

        Username username = new Username(registrationAttributes.getUsername());
        Password password = Password.of(registrationAttributes.getPassword());
        Password encodedPassword = userPasswordEncoder.encodePassword(password);

        User user = new User(username, encodedPassword);

        userRepository.save(user);
    }

}
