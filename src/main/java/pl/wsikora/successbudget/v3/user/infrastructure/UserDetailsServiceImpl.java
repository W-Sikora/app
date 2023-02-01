package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.user.domain.User;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;


@Service
class UserDetailsServiceImpl implements UserDetailsService {

    private static final String MESSAGE = "Could not find user with username: ";

    private final UserRepository userRepository;

    private UserDetailsServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!hasText(username)) {

            throw new UsernameNotFoundException(MESSAGE + username);
        }

        User user = userRepository.getByUsernameAsString(username);

        if (isNull(user)) {

            throw new UsernameNotFoundException(MESSAGE + username);
        }

        return new UserDetailsImpl(user);
    }
}
