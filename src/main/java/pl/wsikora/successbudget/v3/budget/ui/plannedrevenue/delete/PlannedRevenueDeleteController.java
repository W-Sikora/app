package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;


@Controller
@RequestMapping(PLANNED_REVENUE_DELETE_PATH)
class PlannedRevenueDeleteController {

    private final PlannedRevenueCommand plannedRevenueCommand;

    private PlannedRevenueDeleteController(PlannedRevenueCommand plannedRevenueCommand) {

        this.plannedRevenueCommand = plannedRevenueCommand;
    }

    @PostMapping(ID_PATH_VARIABLE)
    private String delete(@PathVariable Long budgetId, @PathVariable Long id) {

        plannedRevenueCommand.delete(id);

        return redirect(BUDGET_PATH, budgetId);
    }

}
