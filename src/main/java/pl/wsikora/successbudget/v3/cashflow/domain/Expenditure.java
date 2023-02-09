package pl.wsikora.successbudget.v3.cashflow.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.money.Money;
import pl.wsikora.successbudget.v3.common.type.*;
import pl.wsikora.successbudget.v3.common.username.Username;

import java.time.LocalDate;


@Entity
@Table(name = "expenditures")
@Getter
@Setter
@NoArgsConstructor
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenditureId;

    @ManyToOne
    @JoinColumn(name = "cash_flow_id")
    private CashFlow cashFlow;

    @Embedded
    private Username owner;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @Embedded
    private CategoryId categoryId;

    @Embedded
    private Money money;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Embedded
    private Payee payee;

    private LocalDate date;

}
