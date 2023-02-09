package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;


@Controller
@RequestMapping(PLANNED_EXPENDITURE_EDIT_PATH)
class PlannedExpenditureEditController {

    private final PlannedExpenditureCommand plannedExpenditureCommand;
    private final PlannedExpenditureFormValidator plannedExpenditureFormValidator;
    private final PlannedExpenditureEditControllerDataProvider plannedExpenditureEditControllerDataProvider;

    private PlannedExpenditureEditController(PlannedExpenditureCommand plannedExpenditureCommand,
                                             PlannedExpenditureFormValidator plannedExpenditureFormValidator,
                                             PlannedExpenditureEditControllerDataProvider plannedExpenditureEditControllerDataProvider) {

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

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(plannedExpenditureFormValidator);
    }

    @ModelAttribute
    private void data(@PathVariable Long budgetId,
                      @RequestParam(required = false) Long id,
                      Model model) {

        model.addAllAttributes(plannedExpenditureEditControllerDataProvider.provideData(budgetId, id));
    }

}
