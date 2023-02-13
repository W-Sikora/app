package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.EXPENDITURE_ADD_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirectToCashFlowPath;


@Controller
@RequestMapping(EXPENDITURE_ADD_PATH)
class ExpenditureEditController {

    private final ExpenditureCommand expenditureCommand;
    private final ExpenditureFormValidator expenditureFormValidator;
    private final ExpenditureEditControllerDataProvider dataProvider;

    private ExpenditureEditController(
        ExpenditureCommand expenditureCommand,
        ExpenditureFormValidator expenditureFormValidator,
        ExpenditureEditControllerDataProvider dataProvider
    ) {

        this.expenditureCommand = expenditureCommand;
        this.expenditureFormValidator = expenditureFormValidator;
        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@ModelAttribute ExpenditureForm expenditureForm,
                        Errors errors, HttpSession session) {

        expenditureFormValidator.validateForm(expenditureForm, errors);

        if (errors.hasErrors()) {

            return VIEW;
        }

        expenditureCommand.save(expenditureForm);

        return redirectToCashFlowPath(session);
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) Long expenditureId, HttpSession session, Model model) {

        model.addAllAttributes(dataProvider.provideData(expenditureId, session));
    }

}
