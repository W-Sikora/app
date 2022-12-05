package pl.wsikora.successbudget.user.infrastructure;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractCommand;
import pl.wsikora.successbudget.user.application.command.UserCommands;
import pl.wsikora.successbudget.user.domain.User;

@Service
@Transactional
class HibernateUserCommand extends AbstractCommand<User> implements UserCommands {

    @Override
    protected Class<User> entityClass() {

        return User.class;
    }
}

