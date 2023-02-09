package pl.wsikora.successbudget.v3.user.ui.majorcurrency;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.user.application.UserCommand;

import javax.validation.Valid;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;


@Controller
@RequestMapping(MAJOR_CURRENCY_EDIT_PATH)
class MajorCurrencyController {

    private final UserCommand userCommand;
    private final MajorCurrencyFormValidator registrationFormValidator;
    private final MajorCurrencyControllerDataProvider registrationControllerDataProvider;

    private MajorCurrencyController(UserCommand userCommand,
                                    MajorCurrencyFormValidator registrationFormValidator,
                                    MajorCurrencyControllerDataProvider registrationControllerDataProvider) {

        this.userCommand = userCommand;
        this.registrationFormValidator = registrationFormValidator;
        this.registrationControllerDataProvider = registrationControllerDataProvider;
    }

    @GetMapping
    private String goToView() {

        return VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute MajorCurrencyForm majorCurrencyForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        userCommand.save(majorCurrencyForm);

        return redirect(DASHBOARD_PATH);
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
