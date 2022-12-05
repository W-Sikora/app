package pl.wsikora.successbudget.budget.application.command;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.budget.domain.Budget;

@Service
public class BudgetCommandService {

    private final BudgetCommand budgetCommand;

    public BudgetCommandService(BudgetCommand budgetCommand) {

        this.budgetCommand = budgetCommand;
    }

    public void save(BudgetFormAttribute attribute) {

        Budget budget = convert(attribute);

        budgetCommand.save(budget);
    }

    public void delete(Long id) {

        budgetCommand.delete(id);
    }

    private Budget convert(BudgetFormAttribute attribute) {

        Budget budget = new Budget();

        return budget;
    }
}
