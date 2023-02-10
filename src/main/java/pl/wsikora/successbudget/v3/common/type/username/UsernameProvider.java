package pl.wsikora.successbudget.v3.common.type.username;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;

import java.util.Optional;


@Service
public class UsernameProvider {

    public Username getUsername() {

        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();

        return Optional.ofNullable(authentication.getName())
            .map(Username::new)
            .orElseThrow(() -> new NotFoundException("username for logged-in user"));
    }

}
