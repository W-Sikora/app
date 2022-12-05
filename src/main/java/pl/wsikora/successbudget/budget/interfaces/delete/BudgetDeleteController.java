package pl.wsikora.successbudget.budget.interfaces.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.currency.application.command.CurrencyCommandService;

import static pl.wsikora.successbudget.budget.interfaces.BudgetConstant.BUDGET_DELETE_URL;
import static pl.wsikora.successbudget.budget.interfaces.BudgetConstant.BUDGET_VIEW_URL;
import static pl.wsikora.successbudget.common.Redirector.redirect;

@Controller
@RequestMapping(BUDGET_DELETE_URL)
class BudgetDeleteController {

    private final CurrencyCommandService currencyCommandService;

    private BudgetDeleteController(CurrencyCommandService currencyCommandService) {

        this.currencyCommandService = currencyCommandService;
    }

    @PostMapping
    private String delete(@PathVariable Long id) {

        currencyCommandService.delete(id);

        return redirect(BUDGET_VIEW_URL);
    }
}
