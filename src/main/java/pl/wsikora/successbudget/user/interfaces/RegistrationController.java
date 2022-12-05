package pl.wsikora.successbudget.user.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractEditController;
import pl.wsikora.successbudget.user.application.command.UserCommandService;

import static pl.wsikora.successbudget.common.Redirector.redirect;


@Controller
@RequestMapping("/registration")
public class RegistrationController extends AbstractEditController<RegistrationForm> {

    private static final String VIEW = "landing/registration-page";

    private final RegistrationFormValidator registrationFormValidator;
    private final UserCommandService userCommandService;

    private RegistrationController(RegistrationFormValidator registrationFormValidator, UserCommandService userCommandService) {

        this.registrationFormValidator = registrationFormValidator;
        this.userCommandService = userCommandService;
    }

    @GetMapping
    protected String goToView() {

        return VIEW;
    }

    @Override
    protected String save(RegistrationForm registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        userCommandService.save(registrationForm);

        return redirect("/");
    }

    @Override
    protected void initData(Long id, ModelMap modelMap) {

        modelMap.addAttribute("registrationForm", new RegistrationForm());
    }

    @Override
    protected void initBinder(WebDataBinder binder) {

        binder.setValidator(registrationFormValidator);
    }
}
