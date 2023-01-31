package pl.wsikora.successbudget.v3.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {

    @EmbeddedId
    private Username userName;

    @Embedded
    private Password password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Role> roles;

    @Embedded
    private Preference preference;

}
