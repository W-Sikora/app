package pl.wsikora.successbudget.v3.user.ui.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElement;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;


@Controller
@RequestMapping(LOGIN_PATH)
class LoginController {

    private final MessageProvider messageProvider;

    private LoginController(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    @GetMapping
    private String goToView() {

        return EDIT_VIEW;
    }

    @ModelAttribute(FORM_PAGE)
    private String formPage() {

        return getEditFormName(LOGIN);
    }

    @ModelAttribute(FORM_ACTION)
    private String formAction() {

        return LOGIN_PATH;
    }

    @ModelAttribute(BREADCRUMB_ELEMENTS)
    private List<BreadcrumbElement> breadcrumbElements() {

        return List.of(
            new BreadcrumbElement(messageProvider.getMessage(LANDING_PAGE_TITLE), SLASH),
            new BreadcrumbElement(messageProvider.getMessage(LOGIN_PAGE_TITLE))
        );
    }

    @ModelAttribute(PAGE_TITLE)
    private String pageTitle() {

        return messageProvider.getMessage(LOGIN_PAGE_TITLE);
    }

    @ModelAttribute("invalid")
    private boolean initData(@RequestParam(required = false) boolean invalid) {

        return invalid;
    }
}
