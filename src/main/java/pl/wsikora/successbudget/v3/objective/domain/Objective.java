package pl.wsikora.successbudget.v3.objective.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Description;
import pl.wsikora.successbudget.v3.common.type.Money;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.Set;


@Entity
@Table(name = "objectives")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long objectiveId;

    @Embedded
    private Username owner;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "currency", column = @Column(name = "necessary_money_currency")),
        @AttributeOverride(name = "value", column = @Column(name = "necessary_money_value"))
    })
    private Money necessaryMoney;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "objective_raised_money", joinColumns = @JoinColumn(name = "objective_id"))
    @AttributeOverrides({
        @AttributeOverride(name = "currency", column = @Column(name = "raised_money_currency")),
        @AttributeOverride(name = "value", column = @Column(name = "raised_money_value"))
    })
    private Set<Money> raisedMoney;

    private boolean realized;

}
