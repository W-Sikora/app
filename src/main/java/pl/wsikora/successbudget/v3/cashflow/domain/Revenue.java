package pl.wsikora.successbudget.v3.cashflow.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.payer.Payer;
import pl.wsikora.successbudget.v3.common.type.title.Title;
import pl.wsikora.successbudget.v3.common.type.username.Username;

import java.time.LocalDate;


@Entity
@Table(name = "revenues")
@Getter
@Setter
@NoArgsConstructor
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long revenueId;

    @ManyToOne
    @JoinColumn(name = "cash_flow_id")
    private CashFlow cashFlow;

    @Embedded
    private Username owner;

    @Embedded
    private Title title;

    @Embedded
    private CategoryId categoryId;

    private LocalDate date;

    @Embedded
    private Money money;

    @Embedded
    private Payer payer;

    private boolean repeatInNextPeriod;

}
