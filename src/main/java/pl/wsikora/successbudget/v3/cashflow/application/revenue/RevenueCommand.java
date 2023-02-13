package pl.wsikora.successbudget.v3.cashflow.application.revenue;

import pl.wsikora.successbudget.v3.common.type.repeat.RepeatCommand;


public interface RevenueCommand {

    void save(RevenueAttributes revenueAttributes);

    void delete(Long revenueId);

    void repeat(RepeatCommand repeatCommand);

}
