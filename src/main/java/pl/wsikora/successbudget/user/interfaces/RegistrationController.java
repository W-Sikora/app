package pl.wsikora.successbudget.user.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.user.application.command.UserCommandService;

import javax.validation.Valid;

import static pl.wsikora.successbudget.common.Constants.*;
import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.common.interfaces.EditControllerUtils.getEditFormName;
import static pl.wsikora.successbudget.user.interfaces.Constant.LOGIN_URL;
import static pl.wsikora.successbudget.user.interfaces.Constant.REGISTRATION;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationFormValidator registrationFormValidator;
    private final UserCommandService userCommandService;

    private RegistrationController(RegistrationFormValidator registrationFormValidator,
                                   UserCommandService userCommandService) {

        this.registrationFormValidator = registrationFormValidator;
        this.userCommandService = userCommandService;
    }

    @GetMapping
    private String goToView() {

        return EDIT_VIEW;
    }

    @PostMapping
    private String save(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return EDIT_VIEW;
        }

        userCommandService.save(registrationForm);

        return redirect(LOGIN_URL);
    }

    @ModelAttribute
    private void initData(ModelMap modelMap) {

        modelMap.addAttribute(REGISTRATION + FORM_SUFIX, new RegistrationForm())
                .addAttribute(FORM_PAGE, getEditFormName(REGISTRATION))
                .addAttribute(PAGE_TITLE, "Rejestracja");
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(registrationFormValidator);
    }
}
