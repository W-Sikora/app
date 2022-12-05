package pl.wsikora.successbudget.user.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;

import static pl.wsikora.successbudget.common.UuidGenerator.generateUuid;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private String name;

    private String email;

    private String password;

    private String uuid;

    public User() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getUuid() {

        return uuid;
    }

    public void setUuid(String uuid) {

        this.uuid = uuid;
    }

    @PrePersist
    private void assignUuid() {

        this.uuid = generateUuid();
    }
}
