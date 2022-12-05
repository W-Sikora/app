package pl.wsikora.successbudget.user.application.command;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.user.domain.User;


@Service
public class UserCommandService {

    private final UserCommand userCommand;
    private final PasswordEncoder passwordEncoder;

    private UserCommandService(UserCommand userCommand, PasswordEncoder passwordEncoder) {

        this.userCommand = userCommand;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(RegistrationFormAttribute attribute) {

        User user = convert(attribute);

        userCommand.save(user);
    }

    private User convert(RegistrationFormAttribute attribute) {

        User user = new User();

        user.setUserName(attribute.getUserName());

        user.setEmail(attribute.getEmail());

        String encodedPassword = passwordEncoder.encode(attribute.getPassword());

        user.setPassword(encodedPassword);

        return user;
    }
}
