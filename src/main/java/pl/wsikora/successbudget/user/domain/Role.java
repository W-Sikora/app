package pl.wsikora.successbudget.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;


@Entity
@Table(name = "roles")
public class Role extends AbstractEntity implements GrantedAuthority {

    @Column(nullable = false)
    private String name;

    public Role() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String getAuthority() {

        return name;
    }
}
