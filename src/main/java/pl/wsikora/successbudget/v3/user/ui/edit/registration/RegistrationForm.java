package pl.wsikora.successbudget.v3.user.ui.edit.registration;

import lombok.*;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
class RegistrationForm implements RegistrationAttributes {

    static final String F_USER_NAME = "userName";
    static final String F_PASSWORD = "password";
    static final String F_REPEATED_PASSWORD = "repeatedPassword";

    private String username;
    private String password;
    private String repeatedPassword;

}
