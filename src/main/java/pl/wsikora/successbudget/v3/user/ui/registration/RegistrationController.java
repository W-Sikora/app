package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElement;
import pl.wsikora.successbudget.v3.user.application.UserCommand;

import javax.validation.Valid;
import java.util.List;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;


@Controller
@RequestMapping(REGISTRATION_PATH)
class RegistrationController {

    private final UserCommand userCommand;
    private final RegistrationFormValidator registrationFormValidator;
    private final MessageProvider messageProvider;

    private RegistrationController(UserCommand userCommand,
                                   RegistrationFormValidator registrationFormValidator,
                                   MessageProvider messageProvider) {

        this.userCommand = userCommand;
        this.registrationFormValidator = registrationFormValidator;
        this.messageProvider = messageProvider;
    }

    @GetMapping
    private String goToView() {

        return EDIT_VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute RegistrationForm registrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return EDIT_VIEW;
        }

        userCommand.save(registrationForm);

        return redirect(LOGIN_PATH);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(registrationFormValidator);
    }

    @ModelAttribute(FORM_PAGE)
    private String formPage() {

        return getEditFormName(REGISTRATION);
    }

    @ModelAttribute(REGISTRATION_FORM)
    private RegistrationForm form() {

        return new RegistrationForm();
    }

    @ModelAttribute(FORM_ACTION)
    private String formAction() {

        return REGISTRATION_PATH;
    }

    @ModelAttribute(BREADCRUMB_ELEMENTS)
    private List<BreadcrumbElement> breadcrumbElements() {

        return List.of(
            new BreadcrumbElement(messageProvider.getMessage(LANDING_PAGE_TITLE), SLASH),
            new BreadcrumbElement(messageProvider.getMessage(REGISTRATION_PAGE_TITLE))
        );
    }

    @ModelAttribute(PAGE_TITLE)
    private String pageTitle() {

        return messageProvider.getMessage(REGISTRATION_PAGE_TITLE);
    }
}
