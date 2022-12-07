package pl.wsikora.successbudget.common.currentuser.application;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.common.currentuser.domain.CurrentUser;
import pl.wsikora.successbudget.user.application.query.UserQuery;
import pl.wsikora.successbudget.user.domain.User;


@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private static final String USERNAME_NOT_FOUND_MESSAGE_FORMAT = "No username %s found";

    private final UserQuery userQuery;

    private CurrentUserDetailsService(UserQuery userQuery) {

        this.userQuery = userQuery;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String errorMessage = String.format(USERNAME_NOT_FOUND_MESSAGE_FORMAT, username);

        User user = userQuery.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(errorMessage));

        return new CurrentUser(
                user.getEmail(),
                user.getPassword(),
                user.getRoles(),
                user.getId(),
                user.getUserName(),
                user.getUuid(),
                user.isConfigured()
        );
    }
}
