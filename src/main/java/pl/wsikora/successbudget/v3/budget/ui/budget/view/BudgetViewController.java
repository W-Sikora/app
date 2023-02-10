package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


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
    private void data(@PathVariable Long id,
                      @RequestParam(defaultValue = DEFAULT_PAGINATION_PAGE) int plannedExpenditurePage,
                      @RequestParam(defaultValue = DEFAULT_PAGINATION_SIZE) int plannedExpenditureSize,
                      @RequestParam(defaultValue = DEFAULT_PAGINATION_PAGE) int plannedRevenuePage,
                      @RequestParam(defaultValue = DEFAULT_PAGINATION_SIZE) int plannedRevenueSize,
                      Model model) {

        model.addAllAttributes(budgetViewControllerDataProvider.provideData(
            id,
            plannedExpenditurePage,
            plannedExpenditureSize,
            plannedRevenuePage,
            plannedRevenueSize
        ));
    }

}
