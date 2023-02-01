package pl.wsikora.successbudget.v3.user.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import pl.wsikora.successbudget.v3.common.type.Username;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @EmbeddedId
    private Username username;

    @Embedded
    private Password password;

}
