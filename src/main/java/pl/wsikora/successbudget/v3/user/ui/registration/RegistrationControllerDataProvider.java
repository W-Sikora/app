package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


@Service
class RegistrationControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;

    private RegistrationControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData() {

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlLandingPagePath(modelMap);

        addAttributePagePathFromForm(modelMap, REGISTRATION);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        addAttributeFormAction(modelMap, REGISTRATION_PATH);

        modelMap.addAttribute("registrationForm", new RegistrationForm());

        String title = messageProvider.getMessage("registration.page.title");

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addLandingPage()
            .add(title)
            .build());

        return modelMap;
    }

}
