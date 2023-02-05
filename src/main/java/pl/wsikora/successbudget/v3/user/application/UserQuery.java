package pl.wsikora.successbudget.v3.user.application;

import pl.wsikora.successbudget.v3.common.type.Username;


public interface UserQuery {

    boolean existsByUsername(Username username);

}
