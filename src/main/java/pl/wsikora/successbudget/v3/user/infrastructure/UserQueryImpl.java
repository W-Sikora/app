package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.user.application.UserQuery;

@Service
class UserQueryImpl implements UserQuery {

    private final UserRepository userRepository;

    private UserQueryImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByUsername(Username username) {

        return userRepository.existsByUsername(username);
    }
}
