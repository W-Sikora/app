package pl.wsikora.successbudget.user.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.user.application.command.UserCommandService;

import javax.validation.Valid;

import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.user.interfaces.Constant.LOGIN_URL;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final String VIEW = "landing/registration-page";

    private final RegistrationFormValidator registrationFormValidator;
    private final UserCommandService userCommandService;

    private RegistrationController(RegistrationFormValidator registrationFormValidator,
                                   UserCommandService userCommandService) {

        this.registrationFormValidator = registrationFormValidator;
        this.userCommandService = userCommandService;
    }

    @GetMapping
    private String goToView() {

        return VIEW;
    }

    @PostMapping
    private String save(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        userCommandService.save(registrationForm);

        return redirect(LOGIN_URL);
    }

    @ModelAttribute
    private void initData(ModelMap modelMap) {

        modelMap.addAttribute("registrationForm", new RegistrationForm());
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(registrationFormValidator);
    }
}
