package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.common.util.databaseconverter.YearMonthDatabaseConverter;

import java.time.YearMonth;


@Entity
@Table(name = "budgets")
@Getter
@Setter
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetId;

    @Embedded
    private Username owner;

    @Convert(converter = YearMonthDatabaseConverter.class)
    private YearMonth period;

}
