package pl.wsikora.successbudget.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;

import static pl.wsikora.successbudget.common.UuidGenerator.generateUuid;
import static pl.wsikora.successbudget.user.common.UserLimitation.*;


@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(length = USER_NAME_MAX_LENGTH)
    private String userName;

    @Column(length = EMAIL_MAX_LENGTH)
    private String email;

    private String password;

    @Column(length = UUID_LENGTH)
    private String uuid;

    private boolean configured;

    public User() {

    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String name) {

        this.userName = name;
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

    public boolean isConfigured() {

        return configured;
    }

    public void setConfigured(boolean configured) {

        this.configured = configured;
    }
}
