package pl.wsikora.successbudget.v3.budget.ui.budget.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.infrastructure.BudgetRepository;

import java.security.Principal;

import static pl.wsikora.successbudget.v3.budget.ui.budget.BudgetConstants.BUDGET_DELETE_PATH;
import static pl.wsikora.successbudget.v3.budget.ui.budget.BudgetConstants.BUDGET_PATH;
import static pl.wsikora.successbudget.v3.common.Constants.ID_PATH_VARIABLE;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;


@Controller
@RequestMapping(BUDGET_DELETE_PATH)
class BudgetDeleteController {

    private final BudgetRepository budgetRepository;

    public BudgetDeleteController(BudgetRepository budgetRepository) {

        this.budgetRepository = budgetRepository;
    }

    @PostMapping(ID_PATH_VARIABLE)
    private String delete(@PathVariable Long id, Principal principal) {

        if (budgetRepository.existsByBudgetIdAndUsername(id, principal.getName())) {

            budgetRepository.deleteById(id);
        }

        return redirect(BUDGET_PATH);
    }
}
