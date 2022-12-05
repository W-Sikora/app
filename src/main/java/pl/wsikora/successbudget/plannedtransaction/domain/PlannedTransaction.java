package pl.wsikora.successbudget.plannedtransaction.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;
import pl.wsikora.successbudget.common.TransactionType;

import java.math.BigDecimal;
import java.time.YearMonth;

@Entity
@Table(name = "planned_transactions")
public class PlannedTransaction extends AbstractEntity {

    private Long budgetId;

    private String name;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Long parentCategoryId;

    private Long categoryId;

    private BigDecimal value;

    private Long currencyId;

    private Long createdByUserId;

    private String cycleValue;

    private YearMonth accountingPeriod;

    public PlannedTransaction() {

    }

    public Long getBudgetId() {

        return budgetId;
    }

    public void setBudgetId(Long budgetId) {

        this.budgetId = budgetId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public TransactionType getTransactionType() {

        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {

        this.transactionType = transactionType;
    }

    public Long getParentCategoryId() {

        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {

        this.parentCategoryId = parentCategoryId;
    }

    public Long getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(Long categoryId) {

        this.categoryId = categoryId;
    }

    public BigDecimal getValue() {

        return value;
    }

    public void setValue(BigDecimal value) {

        this.value = value;
    }

    public Long getCurrencyId() {

        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {

        this.currencyId = currencyId;
    }

    public Long getCreatedByUserId() {

        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {

        this.createdByUserId = createdByUserId;
    }

    public String getCycleValue() {

        return cycleValue;
    }

    public void setCycleValue(String cycleValue) {

        this.cycleValue = cycleValue;
    }

    public YearMonth getAccountingPeriod() {

        return accountingPeriod;
    }

    public void setAccountingPeriod(YearMonth accountingPeriod) {

        this.accountingPeriod = accountingPeriod;
    }
}
