package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.REVENUE_ADD_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirectToCashFlowPath;


@Controller
@RequestMapping(REVENUE_ADD_PATH)
class RevenueEditController {

    private final RevenueCommand revenueCommand;
    private final RevenueFormValidator revenueFormValidator;
    private final RevenueEditControllerDataProvider dataProvider;

    private RevenueEditController(
        RevenueCommand revenueCommand,
        RevenueFormValidator revenueFormValidator,
        RevenueEditControllerDataProvider dataProvider
    ) {

        this.revenueCommand = revenueCommand;
        this.revenueFormValidator = revenueFormValidator;
        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@ModelAttribute RevenueForm revenueForm,
                        Errors errors, HttpSession session) {

        revenueFormValidator.validateForm(revenueForm, errors);

        if (errors.hasErrors()) {

            return VIEW;
        }

        revenueCommand.save(revenueForm);

        return redirectToCashFlowPath(session);
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) Long revenueId, HttpSession session, Model model) {

        model.addAllAttributes(dataProvider.provideData(revenueId, session));
    }

}
