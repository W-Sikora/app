package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.delete;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_EXPENDITURE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirectToBudgetPath;


@Controller
@RequestMapping(PLANNED_EXPENDITURE_DELETE_PATH)
class PlannedExpenditureDeleteController {

    private final PlannedExpenditureCommand plannedExpenditureCommand;

    private PlannedExpenditureDeleteController(PlannedExpenditureCommand plannedExpenditureCommand) {

        this.plannedExpenditureCommand = plannedExpenditureCommand;
    }

    @PostMapping
    private String delete(@PathVariable Long plannedExpenditureId, HttpSession session) {

        plannedExpenditureCommand.delete(plannedExpenditureId);

        return redirectToBudgetPath(session);
    }

}
