package pl.wsikora.successbudget.v3.user.application;

import pl.wsikora.successbudget.v3.user.domain.Password;


public interface UserPasswordEncoder {

    Password encodePassword(Password password);

}
