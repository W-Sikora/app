package pl.wsikora.successbudget.v3.cashflow.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.*;

import java.time.LocalDate;

@Entity
@Table(name = "expenditures")
@Getter
@Setter
@NoArgsConstructor
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Embedded
    private Money money;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Embedded
    private Payee payee;

    @Embedded
    private Schedule schedule;

    private LocalDate date;

}
