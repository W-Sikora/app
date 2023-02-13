package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.delete;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_REVENUE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirectToBudgetPath;


@Controller
@RequestMapping(PLANNED_REVENUE_DELETE_PATH)
class PlannedRevenueDeleteController {

    private final PlannedRevenueCommand plannedRevenueCommand;

    private PlannedRevenueDeleteController(PlannedRevenueCommand plannedRevenueCommand) {

        this.plannedRevenueCommand = plannedRevenueCommand;
    }

    @PostMapping
    private String delete(@PathVariable Long plannedRevenueId, HttpSession session) {

        plannedRevenueCommand.delete(plannedRevenueId);

        return redirectToBudgetPath(session);
    }

}
