package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.user.application.UserPasswordEncoder;
import pl.wsikora.successbudget.v3.user.domain.Password;


@Service
class UserPasswordEncoderImpl implements UserPasswordEncoder {

    private final PasswordEncoder passwordEncoder;

    private UserPasswordEncoderImpl(PasswordEncoder passwordEncoder) {

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Password encodePassword(Password password) {

        String encodedPassword = passwordEncoder.encode(password.getValue());

        return Password.encoded(encodedPassword);
    }

}
