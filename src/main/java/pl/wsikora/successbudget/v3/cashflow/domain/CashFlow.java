package pl.wsikora.successbudget.v3.cashflow.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Description;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.type.Username;


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
    private Title title;

    @Embedded
    private Description description;

    @Embedded
    private Username owner;

}
