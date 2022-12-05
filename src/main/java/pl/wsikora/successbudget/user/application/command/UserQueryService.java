package pl.wsikora.successbudget.user.application.command;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.user.domain.User;

import static pl.wsikora.successbudget.common.CommonMessage.NO_VALUE_FOUND;

@Service
public class UserQueryService {

    private final UserQuery userQuery;

    private UserQueryService(UserQuery userQuery) {

        this.userQuery = userQuery;
    }

    public String getUserNameById(Long id) {

        return userQuery.findById(id)
                .map(User::getName)
                .orElse(NO_VALUE_FOUND);
    }
}
