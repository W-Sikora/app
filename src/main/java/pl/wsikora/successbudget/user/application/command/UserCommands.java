package pl.wsikora.successbudget.user.application.command;


import pl.wsikora.successbudget.user.domain.User;

public interface UserCommands {

    void save(User user);

    void delete(User user);

    void delete(Long id);
}
