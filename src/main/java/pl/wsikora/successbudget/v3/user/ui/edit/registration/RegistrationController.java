package pl.wsikora.successbudget.v3.user.ui.edit.registration;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.user.application.RegistrationAttributes;
import pl.wsikora.successbudget.v3.user.application.UserCommand;

import javax.validation.Valid;
import java.util.Locale;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.ControllerUtils.getEditFormName;
import static pl.wsikora.successbudget.v3.common.Redirector.redirect;
import static pl.wsikora.successbudget.v3.user.ui.Constant.LOGIN_URL;
import static pl.wsikora.successbudget.v3.user.ui.Constant.REGISTRATION;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserCommand userCommand;
    private final RegistrationFormValidator registrationFormValidator;
    private final MessageSource messageSource;

    private RegistrationController(UserCommand userCommand,
                                   RegistrationFormValidator registrationFormValidator,
                                   MessageSource messageSource) {

        this.userCommand = userCommand;
        this.registrationFormValidator = registrationFormValidator;
        this.messageSource = messageSource;
    }

    @GetMapping
    private String goToView() {

        return EDIT_VIEW;
    }

    @PostMapping
    private String save(@Valid RegistrationAttributes registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return EDIT_VIEW;
        }

        userCommand.save(registrationForm);

        return redirect(LOGIN_URL);
    }

    @ModelAttribute
    private void initData(ModelMap modelMap) {

        modelMap.addAttribute(REGISTRATION + FORM_SUFIX, new RegistrationForm())
                .addAttribute(FORM_PAGE, getEditFormName(REGISTRATION))
                .addAttribute(PAGE_TITLE, messageSource.getMessage("registration.page.title",
                    null, Locale.getDefault()));
    }

    @InitBinder("registrationFormValidator")
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(registrationFormValidator);
    }
}
