package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirectWithQueryParameter;


@Controller
@RequestMapping(PLANNED_EXPENDITURE_DELETE_PATH)
class PlannedExpenditureDeleteController {

    private final PlannedExpenditureCommand plannedExpenditureCommand;

    private PlannedExpenditureDeleteController(PlannedExpenditureCommand plannedExpenditureCommand) {

        this.plannedExpenditureCommand = plannedExpenditureCommand;
    }

    @PostMapping(ID_PATH_VARIABLE)
    private String delete(@PathVariable Long budgetId, @PathVariable Long id) {

        plannedExpenditureCommand.delete(id);

        return redirectWithQueryParameter(BUDGET_PARTICULAR_PATH, budgetId);
    }

}
