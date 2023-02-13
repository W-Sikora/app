package pl.wsikora.successbudget.v3.user.application;

public interface RegistrationQuery {

    boolean existsByUsername(String username);

}
