package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.delete;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.EXPENDITURE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirectToCashFlowPath;


@Controller
@RequestMapping(EXPENDITURE_DELETE_PATH)
class ExpenditureDeleteController {

    private final ExpenditureCommand expenditureCommand;

    private ExpenditureDeleteController(ExpenditureCommand expenditureCommand) {

        this.expenditureCommand = expenditureCommand;
    }

    @PostMapping
    private String delete(@PathVariable Long expenditureId, HttpSession session) {

        expenditureCommand.delete(expenditureId);

        return redirectToCashFlowPath(session);
    }

}
