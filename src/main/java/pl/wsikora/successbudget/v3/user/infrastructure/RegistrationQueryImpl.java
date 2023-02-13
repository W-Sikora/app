package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.user.application.RegistrationQuery;


@Service
class RegistrationQueryImpl implements RegistrationQuery {

    private final UserRepository userRepository;

    private RegistrationQueryImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByUsername(String username) {

        return userRepository.existsByUsername(username);
    }

}
