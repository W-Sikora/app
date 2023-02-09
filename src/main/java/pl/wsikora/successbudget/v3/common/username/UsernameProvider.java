package pl.wsikora.successbudget.v3.common.username;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.exception.NotFoundException;

import java.security.Principal;
import java.util.Optional;


@Service
public class UsernameProvider {

    public Username getUsername() {

        Principal principal = (Principal) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();

        return Optional.ofNullable(principal.getName())
            .map(Username::new)
            .orElseThrow(() -> new NotFoundException("username for logged-in user"));
    }

}
