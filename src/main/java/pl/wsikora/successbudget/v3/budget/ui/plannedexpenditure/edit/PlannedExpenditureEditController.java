package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;

import javax.validation.Valid;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(PLANNED_EXPENDITURE_ADD_PATH)
class PlannedExpenditureEditController {

    private final PlannedExpenditureCommand plannedExpenditureCommand;
    private final PlannedExpenditureFormValidator plannedExpenditureFormValidator;
    private final PlannedExpenditureEditControllerDataProvider plannedExpenditureEditControllerDataProvider;

    private PlannedExpenditureEditController(
        PlannedExpenditureCommand plannedExpenditureCommand,
        PlannedExpenditureFormValidator plannedExpenditureFormValidator,
        PlannedExpenditureEditControllerDataProvider plannedExpenditureEditControllerDataProvider
    ) {

        this.plannedExpenditureCommand = plannedExpenditureCommand;
        this.plannedExpenditureFormValidator = plannedExpenditureFormValidator;
        this.plannedExpenditureEditControllerDataProvider = plannedExpenditureEditControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute PlannedExpenditureForm plannedExpenditureForm,
                        BindingResult bindingResult,
                        @PathVariable Long budgetId) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        plannedExpenditureCommand.save(plannedExpenditureForm);

        return redirect(BUDGET_PATH, budgetId);
    }

    @InitBinder("plannedExpenditureFormValidator")
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(plannedExpenditureFormValidator);
    }

    @ModelAttribute
    private void data(PlannedExpenditureEditCommand editCommand, Model model) {

        model.addAllAttributes(plannedExpenditureEditControllerDataProvider.provideData(editCommand));
    }

}
