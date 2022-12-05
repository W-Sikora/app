package pl.wsikora.successbudget.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractCommand;
import pl.wsikora.successbudget.budget.application.command.BudgetCommand;
import pl.wsikora.successbudget.budget.domain.Budget;

@Service
class HibernateBudgetCommand extends AbstractCommand<Budget> implements BudgetCommand {

    @Override
    protected Class<Budget> entityClass() {

        return Budget.class;
    }
}
