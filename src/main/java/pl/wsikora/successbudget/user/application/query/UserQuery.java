package pl.wsikora.successbudget.user.application.query;


import pl.wsikora.successbudget.user.domain.User;

import java.util.Optional;

public interface UserQuery {

    Optional<User> findById(Long id);

    User getById(Long id);

}
