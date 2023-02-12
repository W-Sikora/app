package pl.wsikora.successbudget.v3.cashflow.application.revenue;

public interface RevenueCommand {

    void save(RevenueAttributes revenueAttributes);

    void delete(Long cashFlowId, Long revenueId);

    void repeat(Long fromCashFlowId, Long toCashFlowId);

}
