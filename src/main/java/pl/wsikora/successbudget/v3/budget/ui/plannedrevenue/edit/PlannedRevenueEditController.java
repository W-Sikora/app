package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(PLANNED_REVENUE_EDIT_PATH)
class PlannedRevenueEditController {

    private final PlannedRevenueCommand plannedRevenueCommand;
    private final PlannedRevenueFormValidator plannedRevenueFormValidator;
    private final PlannedRevenueEditControllerDataProvider plannedExpenditureEditControllerDataProvider;

    private PlannedRevenueEditController(PlannedRevenueCommand plannedRevenueCommand,
                                         PlannedRevenueFormValidator plannedRevenueFormValidator,
                                         PlannedRevenueEditControllerDataProvider plannedExpenditureEditControllerDataProvider) {

        this.plannedRevenueCommand = plannedRevenueCommand;
        this.plannedRevenueFormValidator = plannedRevenueFormValidator;
        this.plannedExpenditureEditControllerDataProvider = plannedExpenditureEditControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute PlannedRevenueForm plannedRevenueForm,
                        BindingResult bindingResult,
                        @PathVariable Long budgetId) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        plannedRevenueCommand.save(plannedRevenueForm);

        return redirect(BUDGET_PATH, budgetId);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(plannedRevenueFormValidator);
    }

    @ModelAttribute
    private void data(@PathVariable Long budgetId,
                      @RequestParam(required = false) Long id,
                      Model model) {

        model.addAllAttributes(plannedExpenditureEditControllerDataProvider.provideData(budgetId, id));
    }

}
