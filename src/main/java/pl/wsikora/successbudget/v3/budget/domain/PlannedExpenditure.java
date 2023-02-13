package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.common.util.databaseconverter.YearMonthDatabaseConverter;

import java.time.YearMonth;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "planned_expenditures")
public class PlannedExpenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plannedExpenditureId;

    @Convert(converter = YearMonthDatabaseConverter.class)
    private YearMonth period;

    @Embedded
    private Username owner;

    @Embedded
    private CategoryId categoryId;

    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

    @Embedded
    private Money money;

    private boolean repeatInNextPeriod;

}
