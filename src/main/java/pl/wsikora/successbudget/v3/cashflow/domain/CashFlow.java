package pl.wsikora.successbudget.v3.cashflow.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.common.util.YearMonthConverter;

import java.time.YearMonth;


@Entity
@Table(name = "cash_flows")
@Getter
@Setter
@NoArgsConstructor
public class CashFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cashFlowId;

    @Embedded
    private Username owner;

    @Convert(converter = YearMonthConverter.class)
    private YearMonth period;

}
