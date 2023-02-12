package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.BUDGET_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.EXPENDITURE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(EXPENDITURE_DELETE_PATH)
class ExpenditureDeleteController {

//    private final PlannedExpenditureCommand expenditureCommand;
//
//    private ExpenditureDeleteController(PlannedExpenditureCommand expenditureCommand) {
//
//        this.expenditureCommand = expenditureCommand;
//    }
//
//    @PostMapping
//    private String delete(@PathVariable Long cashFlowId, @PathVariable Long id) {
//
//        expenditureCommand.delete(cashFlowId, id);
//
//        return redirect(BUDGET_PATH, cashFlowId);
//    }

}
