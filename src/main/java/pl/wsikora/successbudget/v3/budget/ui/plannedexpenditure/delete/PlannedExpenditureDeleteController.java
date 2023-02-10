package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(PLANNED_EXPENDITURE_DELETE_PATH)
class PlannedExpenditureDeleteController {

    private final PlannedExpenditureCommand plannedExpenditureCommand;

    private PlannedExpenditureDeleteController(PlannedExpenditureCommand plannedExpenditureCommand) {

        this.plannedExpenditureCommand = plannedExpenditureCommand;
    }

    @PostMapping
    private String delete(@PathVariable Long budgetId, @PathVariable Long id) {

        plannedExpenditureCommand.delete(id);

        return redirect(BUDGET_PATH, budgetId);
    }

}
