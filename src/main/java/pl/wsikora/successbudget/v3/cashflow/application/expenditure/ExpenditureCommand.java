package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowRepeatCommand;


public interface ExpenditureCommand {

    void save(ExpenditureAttributes expenditureAttributes);

    void delete(ExpenditureDeleteCommand expenditureDeleteCommand);

    void repeat(CashFlowRepeatCommand cashFlowRepeatCommand);

}
