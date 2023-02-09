package pl.wsikora.successbudget.v3.objective.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.money.Money;
import pl.wsikora.successbudget.v3.common.username.Username;

import java.time.LocalDate;


@Entity
@Table(name = "raised_money")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RaisedMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long raisedMoneyId;

    @Embedded
    private Username owner;

    @ManyToOne
    @JoinColumn(name = "objective_id")
    private Objective objective;

    @Embedded
    private Money money;

    private LocalDate date;

}
