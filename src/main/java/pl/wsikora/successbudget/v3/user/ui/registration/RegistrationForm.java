package pl.wsikora.successbudget.v3.user.ui.registration;

import lombok.*;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
class RegistrationForm implements RegistrationAttributes {

    private String username;
    private String password;
    private String repeatedPassword;

}
