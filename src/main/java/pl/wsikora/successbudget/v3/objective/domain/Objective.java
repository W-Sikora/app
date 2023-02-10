package pl.wsikora.successbudget.v3.objective.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.description.Description;
import pl.wsikora.successbudget.v3.common.type.title.Title;
import pl.wsikora.successbudget.v3.common.type.username.Username;


@Entity
@Table(name = "objectives")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long objectiveId;

    @Embedded
    private Username owner;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @Embedded
    private Money necessaryMoney;

    private boolean realized;

}
