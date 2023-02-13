package pl.wsikora.successbudget.v3.cashflow.ui.revenue.delete;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.REVENUE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirectToCashFlowPath;


@Controller
@RequestMapping(REVENUE_DELETE_PATH)
class RevenueDeleteController {

    private final RevenueCommand revenueCommand;

    private RevenueDeleteController(RevenueCommand revenueCommand) {

        this.revenueCommand = revenueCommand;
    }

    @PostMapping
    private String delete(@PathVariable Long revenueId, HttpSession session) {

        revenueCommand.delete(revenueId);

        return redirectToCashFlowPath(session);
    }

}
