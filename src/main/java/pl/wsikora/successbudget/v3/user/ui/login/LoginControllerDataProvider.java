package pl.wsikora.successbudget.v3.user.ui.login;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


@Service
class LoginControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;

    private LoginControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData(boolean invalid) {

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlLandingPagePath(modelMap);

        addAttributePagePathFromForm(modelMap, LOGIN);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        addAttributeFormAction(modelMap, LOGIN_PATH);

        String title = messageProvider.getMessage("login.page.title");

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute("invalid", invalid);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addLandingPage()
            .add(title)
            .build());

        return modelMap;
    }

}
