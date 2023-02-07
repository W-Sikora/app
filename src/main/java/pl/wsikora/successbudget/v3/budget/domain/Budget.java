package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.common.util.YearMonthConverter;

import java.time.YearMonth;


@Entity
@Table(name = "budgets")
@Getter
@Setter
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long budgetId;

    @Embedded
    private Username owner;

    @Convert(converter = YearMonthConverter.class)
    private YearMonth period;

}
