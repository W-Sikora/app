package pl.wsikora.successbudget.v3.user.ui.login;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;


@Service
class LoginControllerDataProvider {

    private final MessageProvider messageProvider;

    private LoginControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData(boolean invalid) {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, LANDING_PAGE_PATH);

        modelMap.addAttribute(PAGE_PATH, getEditFormName(LOGIN));

        modelMap.addAttribute(COLUMN_SIZE, "is-5");

        modelMap.addAttribute(FORM_ACTION, LOGIN_PATH);

        String title = messageProvider.getMessage("login.page.title");

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute("invalid", invalid);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(LANDING_PAGE_TITLE), LANDING_PAGE_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        return modelMap;
    }

}
