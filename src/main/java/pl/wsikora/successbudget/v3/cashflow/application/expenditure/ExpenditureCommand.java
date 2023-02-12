package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

public interface ExpenditureCommand {

    void save(ExpenditureAttributes expenditureAttributes);

    void delete(Long cashFlowId, Long expenditureId);

    void repeat(Long fromCashFlowId, Long toCashFlowId);

}
