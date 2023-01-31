package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;
import pl.wsikora.successbudget.v3.user.application.UserCommand;


@Service
class UserCommandImpl implements UserCommand {

    @Override
    public void save(RegistrationAttributes registrationAttributes) {

    }
}
