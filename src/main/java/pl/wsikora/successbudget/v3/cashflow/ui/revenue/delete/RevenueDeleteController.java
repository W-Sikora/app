package pl.wsikora.successbudget.v3.cashflow.ui.revenue.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.BUDGET_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.REVENUE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(REVENUE_DELETE_PATH)
class RevenueDeleteController {

//    private final PlannedRevenueCommand revenueCommand;
//
//    private RevenueDeleteController(PlannedRevenueCommand revenueCommand) {
//
//        this.revenueCommand = revenueCommand;
//    }
//
//    @PostMapping
//    private String delete(@PathVariable Long cashFlowId, @PathVariable Long id) {
//
//        revenueCommand.delete(cashFlowId, id);
//
//        return redirect(BUDGET_PATH, cashFlowId);
//    }

}
