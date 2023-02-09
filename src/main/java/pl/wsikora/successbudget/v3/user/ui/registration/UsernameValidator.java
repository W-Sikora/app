package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.username.Username;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.user.application.UserQuery;


import static org.springframework.util.StringUtils.hasText;
import static pl.wsikora.successbudget.v3.common.username.Username.hasValidLength;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.EMPTY;


@Service
class UsernameValidator extends AbstractFormValidator<String> {

    static final String E_USERNAME_MUST_BE_UNIQUE = "username.must.be.unique";
    static final String F_USER_NAME = "username";

    private final UserQuery userQuery;

    UsernameValidator(UserQuery userQuery) {

        this.userQuery = userQuery;
    }

    @Override
    public void validateForm(String username, Errors errors) {

        if (!hasText(username)) {

            errors.rejectValue(F_USER_NAME, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!hasValidLength(username)) {

            errors.rejectValue(F_USER_NAME, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Username.getLengthRange(), EMPTY);
        }
        else if (userQuery.existsByUsername(new Username(username))) {

            errors.rejectValue(F_USER_NAME, E_USERNAME_MUST_BE_UNIQUE);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(String.class);
    }

}
