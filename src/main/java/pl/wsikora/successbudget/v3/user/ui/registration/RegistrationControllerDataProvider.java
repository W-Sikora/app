package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;


@Service
class RegistrationControllerDataProvider {

    private final MessageProvider messageProvider;

    private RegistrationControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData() {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, LANDING_PAGE_PATH);

        modelMap.addAttribute(PAGE_PATH, getEditFormName(REGISTRATION));

        modelMap.addAttribute(COLUMN_SIZE, "is-6");

        modelMap.addAttribute(FORM_ACTION, REGISTRATION_PATH);

        modelMap.addAttribute(FORM, new RegistrationForm());

        String title = messageProvider.getMessage("registration.page.title");

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(LANDING_PAGE_TITLE), LANDING_PAGE_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        return modelMap;
    }

}
