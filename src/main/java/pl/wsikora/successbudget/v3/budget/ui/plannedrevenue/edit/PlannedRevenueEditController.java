package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.PLANNED_REVENUE_ADD_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirectToBudgetPath;


@Controller
@RequestMapping(PLANNED_REVENUE_ADD_PATH)
class PlannedRevenueEditController {

    private final PlannedRevenueCommand plannedRevenueCommand;
    private final PlannedRevenueFormValidator plannedRevenueFormValidator;
    private final PlannedRevenueEditControllerDataProvider dataProvider;

    private PlannedRevenueEditController(
        PlannedRevenueCommand plannedRevenueCommand,
        PlannedRevenueFormValidator plannedRevenueFormValidator,
        PlannedRevenueEditControllerDataProvider dataProvider
    ) {

        this.plannedRevenueCommand = plannedRevenueCommand;
        this.plannedRevenueFormValidator = plannedRevenueFormValidator;
        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@ModelAttribute PlannedRevenueForm plannedRevenueForm,
                        Errors errors, HttpSession session) {

        plannedRevenueFormValidator.validateForm(plannedRevenueForm, errors);

        if (errors.hasErrors()) {

            return VIEW;
        }

        plannedRevenueCommand.save(plannedRevenueForm);

        return redirectToBudgetPath(session);
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) Long plannedRevenueId, HttpSession session, Model model) {

        model.addAllAttributes(dataProvider.provideData(plannedRevenueId, session));
    }

}
