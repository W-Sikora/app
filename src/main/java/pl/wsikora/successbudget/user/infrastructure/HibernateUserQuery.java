package pl.wsikora.successbudget.user.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractQuery;
import pl.wsikora.successbudget.user.application.command.UserQuery;
import pl.wsikora.successbudget.user.domain.User;

@Service

class HibernateUserQuery extends AbstractQuery<User> implements UserQuery {

    @Override
    protected Class<User> entityClass() {

        return User.class;
    }
}
