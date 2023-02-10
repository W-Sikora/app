package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.user.application.UserCommand;

import javax.validation.Valid;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(REGISTRATION_PATH)
class RegistrationController {

    private final UserCommand userCommand;
    private final RegistrationFormValidator registrationFormValidator;
    private final RegistrationControllerDataProvider registrationControllerDataProvider;

    private RegistrationController(UserCommand userCommand,
                                   RegistrationFormValidator registrationFormValidator,
                                   RegistrationControllerDataProvider registrationControllerDataProvider) {

        this.userCommand = userCommand;
        this.registrationFormValidator = registrationFormValidator;
        this.registrationControllerDataProvider = registrationControllerDataProvider;
    }

    @GetMapping
    private String goToView() {

        return VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute RegistrationForm registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        userCommand.save(registrationForm);

        return redirect(LOGIN_PATH);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(registrationFormValidator);
    }

    @ModelAttribute
    private void data(Model model) {

        model.addAllAttributes(registrationControllerDataProvider.provideData());
    }

}
