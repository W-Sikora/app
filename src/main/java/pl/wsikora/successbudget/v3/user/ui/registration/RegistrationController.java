package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.user.application.RegistrationCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(REGISTRATION_PATH)
class RegistrationController {

    private final RegistrationCommand registrationCommand;
    private final RegistrationFormValidator registrationFormValidator;
    private final RegistrationControllerDataProvider registrationControllerDataProvider;

    private RegistrationController(
        RegistrationCommand registrationCommand,
        RegistrationFormValidator registrationFormValidator,
        RegistrationControllerDataProvider registrationControllerDataProvider
    ) {

        this.registrationCommand = registrationCommand;
        this.registrationFormValidator = registrationFormValidator;
        this.registrationControllerDataProvider = registrationControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@ModelAttribute RegistrationForm registrationForm, Errors errors) {

        registrationFormValidator.validateForm(registrationForm, errors);

        if (errors.hasErrors()) {

            return VIEW;
        }

        registrationCommand.save(registrationForm);

        return redirect(LOGIN_PATH);
    }

    @ModelAttribute
    private void data(Model model) {

        model.addAllAttributes(registrationControllerDataProvider.provideData());
    }

}
