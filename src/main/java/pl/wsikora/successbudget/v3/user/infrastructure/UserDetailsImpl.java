package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.wsikora.successbudget.v3.user.domain.User;

import java.util.Collection;
import java.util.List;

import static pl.wsikora.successbudget.v3.config.security.SecurityConfig.USER_ROLE;


class UserDetailsImpl implements UserDetails {

    private final User user;

    UserDetailsImpl(User user) {

        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(USER_ROLE));
    }

    @Override
    public String getPassword() {

        return user.getPassword().getValue();
    }

    @Override
    public String getUsername() {

        return user.getUsername().getValue();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

}
