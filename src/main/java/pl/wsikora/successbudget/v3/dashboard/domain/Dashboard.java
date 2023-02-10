package pl.wsikora.successbudget.v3.dashboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.budget.BudgetId;
import pl.wsikora.successbudget.v3.common.cashflow.CashFlowId;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.common.util.databaseconverter.YearMonthDatabaseConverter;

import java.time.YearMonth;

@Entity
@Table(name = "dashboards")
@Getter
@Setter
@NoArgsConstructor
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dashboardId;

    private Username owner;

    @Convert(converter = YearMonthDatabaseConverter.class)
    private YearMonth period;

    @Embedded
    private BudgetId budgetId;

    @Embedded
    private CashFlowId cashFlowId;

}
