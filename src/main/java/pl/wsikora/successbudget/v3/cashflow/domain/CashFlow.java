package pl.wsikora.successbudget.v3.cashflow.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;


@Entity
@Table(name = "cash_flows")
@Getter
@Setter
@NoArgsConstructor
public class CashFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cashFlowId;

    @Embedded
    private Username owner;

    @OneToMany
    private List<Expenditure> expenditures;

    @OneToMany
    private List<Revenue> revenues;

}
