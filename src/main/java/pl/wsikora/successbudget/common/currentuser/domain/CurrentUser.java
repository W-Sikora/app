package pl.wsikora.successbudget.common.currentuser.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class CurrentUser extends User {

    private final Long id;
    private final String name;
    private final String uuid;
    private final boolean configured;

    public CurrentUser(String username,
                       String password,
                       Collection<? extends GrantedAuthority> authorities,
                       Long id,
                       String name,
                       String uuid,
                       boolean configured) {

        super(username, password, authorities);

        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.configured = configured;
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getEmail() {

        return getUsername();
    }

    public String getUuid() {

        return uuid;
    }

    public boolean isConfigured() {

        return configured;
    }
}
