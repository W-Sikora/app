package pl.wsikora.successbudget.plannedtransaction.interfaces.edit;


import pl.wsikora.successbudget.plannedtransaction.application.command.PlannedTransactionFormAttribute;

import java.math.BigDecimal;
import java.time.YearMonth;

class PlannedTransactionForm implements PlannedTransactionFormAttribute {

    static final String F_BUDGET_ID = "budgetId";
    static final String F_NAME = "name";
    static final String F_TRANSACTION_TYPE_ID = "transactionTypeId";
    static final String F_CATEGORY_ID = "categoryId";
    static final String F_VALUE = "value";
    static final String F_CURRENCY_ID = "currencyId";
    static final String F_CYCLE_VALUE = "cycleValue";
    static final String F_ACCOUNTING_PERIOD = "accountingPeriod";

    private Long id;
    private Long budgetId;
    private String name;
    private Long transactionTypeId;
    private Long parentCategoryId;
    private Long categoryId;
    private BigDecimal value;
    private Long currencyId;
    private Long createdByUserId;
    private String cycleValue;
    private YearMonth accountingPeriod;

    @Override
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Override
    public Long getBudgetId() {

        return budgetId;
    }

    public void setBudgetId(Long budgetId) {

        this.budgetId = budgetId;
    }

    @Override
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public Long getTransactionTypeId() {

        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {

        this.transactionTypeId = transactionTypeId;
    }

    @Override
    public Long getParentCategoryId() {

        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {

        this.parentCategoryId = parentCategoryId;
    }

    @Override
    public Long getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(Long categoryId) {

        this.categoryId = categoryId;
    }

    @Override
    public BigDecimal getValue() {

        return value;
    }

    public void setValue(BigDecimal value) {

        this.value = value;
    }

    @Override
    public Long getCurrencyId() {

        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {

        this.currencyId = currencyId;
    }

    @Override
    public Long getCreatedByUserId() {

        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {

        this.createdByUserId = createdByUserId;
    }

    @Override
    public String getCycleValue() {

        return cycleValue;
    }

    public void setCycleValue(String cycleValue) {

        this.cycleValue = cycleValue;
    }

    @Override
    public YearMonth getAccountingPeriod() {

        return accountingPeriod;
    }

    public void setAccountingPeriod(YearMonth accountingPeriod) {

        this.accountingPeriod = accountingPeriod;
    }
}
