package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import pl.wsikora.successbudget.v3.common.type.repeat.RepeatCommand;


public interface ExpenditureCommand {

    void save(ExpenditureAttributes expenditureAttributes);

    void delete(Long expenditureId);

    void repeat(RepeatCommand repeatCommand);

}
