package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.categoryid.CategoryId;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.common.util.databaseconverter.YearMonthDatabaseConverter;

import java.time.YearMonth;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "planned_revenues")
public class PlannedRevenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plannedRevenueId;

    @Convert(converter = YearMonthDatabaseConverter.class)
    private YearMonth period;

    @Embedded
    private Username owner;

    @Embedded
    private CategoryId categoryId;

    @Embedded
    private Money money;

    private boolean repeatInNextPeriod;

}
