package pl.wsikora.successbudget.v3.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.username.Username;


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

    @Enumerated(EnumType.ORDINAL)
    private Currency majorCurrency;

}
