package pl.wsikora.successbudget.plannedtransaction.domain;

import jakarta.persistence.*;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;
import pl.wsikora.successbudget.common.TransactionType;
import pl.wsikora.successbudget.common.type.*;

import java.time.YearMonth;

import static pl.wsikora.successbudget.common.Constants.ID;


@Entity
@Table(name = "planned_transactions")
public class PlannedTransaction extends AbstractEntity {

    @Embedded
    @AttributeOverride(name = PlannedTransactionId.D_VALUE, column = @Column(name = ID, nullable = false))
    private PlannedTransactionId id;

    @Embedded
    private BudgetId budgetId;

    @Embedded
    private TransactionTitle title;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Long parentCategoryId;

    private Long categoryId;

    @Embedded
    private Money money;

    @Embedded
    private UserId createdBy;

    private String cycleValue;

    private YearMonth accountingPeriod;


}
