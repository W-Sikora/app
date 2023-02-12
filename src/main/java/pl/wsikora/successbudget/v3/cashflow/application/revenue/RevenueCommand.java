package pl.wsikora.successbudget.v3.cashflow.application.revenue;

import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowRepeatCommand;


public interface RevenueCommand {

    void save(RevenueAttributes revenueAttributes);

    void delete(RevenueDeleteCommand revenueDeleteCommand);

    void repeat(CashFlowRepeatCommand cashFlowRepeatCommand);

}
