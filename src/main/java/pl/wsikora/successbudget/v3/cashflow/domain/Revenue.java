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
import pl.wsikora.successbudget.v3.common.util.databaseconverter.YearMonthDatabaseConverter;

import java.time.LocalDate;
import java.time.YearMonth;


@Entity
@Table(name = "revenues")
@Getter
@Setter
@NoArgsConstructor
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long revenueId;

    @Convert(converter = YearMonthDatabaseConverter.class)
    private YearMonth period;

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
