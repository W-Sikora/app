package pl.wsikora.successbudget.v3.dashboard.ui;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;

import static pl.wsikora.successbudget.v3.common.Constants.*;


@Service
class DashboardControllerDataProvider {

    private final MessageProvider messageProvider;

    private DashboardControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData() {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(FORM_ACTION, CATEGORY_EDIT_PATH);

        String title = messageProvider.getMessage(DASHBOARD_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        return modelMap;
    }

}
