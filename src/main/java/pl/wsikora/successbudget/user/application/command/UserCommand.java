package pl.wsikora.successbudget.user.application.command;

import pl.wsikora.successbudget.user.domain.User;


public interface UserCommand {

    void save(User user);

    void delete(long id);
}
