package pl.wsikora.successbudget.v3.cashflow.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.*;

import java.time.LocalDate;


@Entity
@Table(name = "revenues")
@Getter
@Setter
@NoArgsConstructor
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long revenueId;

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

    @Embedded
    private Payer payer;

    @Embedded
    private Schedule schedule;

    private LocalDate date;

}
