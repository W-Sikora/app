package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueDeleteCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.BUDGET_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_REVENUE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(PLANNED_REVENUE_DELETE_PATH)
class PlannedRevenueDeleteController {

    private final PlannedRevenueCommand plannedRevenueCommand;

    private PlannedRevenueDeleteController(PlannedRevenueCommand plannedRevenueCommand) {

        this.plannedRevenueCommand = plannedRevenueCommand;
    }

    @PostMapping
    private String delete(PlannedRevenueDeleteCommand plannedRevenueDeleteCommand) {

        plannedRevenueCommand.delete(plannedRevenueDeleteCommand);

        return redirect(BUDGET_PATH, plannedRevenueDeleteCommand.budgetId());
    }

}
