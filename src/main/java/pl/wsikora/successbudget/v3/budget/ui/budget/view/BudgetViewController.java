package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static pl.wsikora.successbudget.v3.common.Constants.BUDGET_PATH;
import static pl.wsikora.successbudget.v3.common.Constants.VIEW;


@Controller
@RequestMapping(BUDGET_PATH)
class BudgetViewController {

    private final BudgetViewControllerDataProvider budgetViewControllerDataProvider;

    private BudgetViewController(BudgetViewControllerDataProvider budgetViewControllerDataProvider) {

        this.budgetViewControllerDataProvider = budgetViewControllerDataProvider;
    }

    @GetMapping
    private String goToView() {

        return VIEW;
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) String period, Model model) {

        model.addAllAttributes(budgetViewControllerDataProvider.provideData(period));
    }

}
