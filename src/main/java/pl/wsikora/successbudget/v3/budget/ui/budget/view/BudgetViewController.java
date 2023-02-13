package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static pl.wsikora.successbudget.v3.common.util.Constants.BUDGET_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;


@Controller
@RequestMapping(BUDGET_PATH)
class BudgetViewController {

    private final BudgetViewControllerDataProvider dataProvider;

    private BudgetViewController(BudgetViewControllerDataProvider dataProvider) {

        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @ModelAttribute
    private void data(BudgetViewParameters parameters, Model model) {

        model.addAllAttributes(dataProvider.provideData(parameters));
    }

}
