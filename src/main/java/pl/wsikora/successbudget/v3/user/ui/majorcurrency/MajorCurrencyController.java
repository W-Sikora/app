package pl.wsikora.successbudget.v3.user.ui.majorcurrency;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.user.application.MajorCurrencyCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(MAJOR_CURRENCY_EDIT_PATH)
class MajorCurrencyController {

    private final MajorCurrencyCommand majorCurrencyCommand;
    private final MajorCurrencyFormValidator majorCurrencyFormValidator;
    private final MajorCurrencyControllerDataProvider registrationControllerDataProvider;

    private MajorCurrencyController(
        MajorCurrencyCommand majorCurrencyCommand,
        MajorCurrencyFormValidator majorCurrencyFormValidator,
        MajorCurrencyControllerDataProvider registrationControllerDataProvider) {

        this.majorCurrencyCommand = majorCurrencyCommand;
        this.majorCurrencyFormValidator = majorCurrencyFormValidator;
        this.registrationControllerDataProvider = registrationControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@ModelAttribute MajorCurrencyForm majorCurrencyForm, Errors errors) {

        majorCurrencyFormValidator.validateForm(majorCurrencyForm, errors);

        if (errors.hasErrors()) {

            return VIEW;
        }

        majorCurrencyCommand.save(majorCurrencyForm);

        return redirect(DASHBOARD_PATH);
    }

    @ModelAttribute
    private void data(Model model, HttpSession session) {

        model.addAllAttributes(registrationControllerDataProvider.provideData(session));
    }

}
