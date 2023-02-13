package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_EXPENDITURE_ADD_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirectToBudgetPath;


@Controller
@RequestMapping(PLANNED_EXPENDITURE_ADD_PATH)
class PlannedExpenditureEditController {

    private final PlannedExpenditureCommand plannedExpenditureCommand;
    private final PlannedExpenditureFormValidator plannedExpenditureFormValidator;
    private final PlannedExpenditureEditControllerDataProvider dataProvider;

    private PlannedExpenditureEditController(
        PlannedExpenditureCommand plannedExpenditureCommand,
        PlannedExpenditureFormValidator plannedExpenditureFormValidator,
        PlannedExpenditureEditControllerDataProvider dataProvider
    ) {

        this.plannedExpenditureCommand = plannedExpenditureCommand;
        this.plannedExpenditureFormValidator = plannedExpenditureFormValidator;
        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@ModelAttribute PlannedExpenditureForm plannedExpenditureForm,
                        Errors errors, HttpSession session) {

        plannedExpenditureFormValidator.validateForm(plannedExpenditureForm, errors);

        if (errors.hasErrors()) {

            return VIEW;
        }

        plannedExpenditureCommand.save(plannedExpenditureForm);

        return redirectToBudgetPath(session);
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) Long plannedExpenditureId, HttpSession session, Model model) {

        model.addAllAttributes(dataProvider.provideData(plannedExpenditureId, session));
    }

}
