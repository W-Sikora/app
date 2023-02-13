package pl.wsikora.successbudget.v3.cashflow.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.categoryid.CategoryId;
import pl.wsikora.successbudget.v3.common.type.date.Date;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.payee.Payee;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.title.Title;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.common.util.databaseconverter.YearMonthDatabaseConverter;

import java.time.YearMonth;


@Entity
@Table(name = "expenditures")
@Getter
@Setter
@NoArgsConstructor
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenditureId;

    @Convert(converter = YearMonthDatabaseConverter.class)
    private YearMonth period;

    @Embedded
    private Username owner;

    @Embedded
    private Title title;

    @Embedded
    private CategoryId categoryId;

    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

    @Embedded
    private Date date;

    @Embedded
    private Money money;

    @Embedded
    private Payee payee;

    private boolean repeatInNextPeriod;

}
