package pl.wsikora.successbudget.v3.dashboard.ui.view;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import static java.util.Objects.nonNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.fillPath;


@Service
class DashboardControllerDataProvider {

    private final MessageProvider messageProvider;

    private DashboardControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData(String period) {

        if (nonNull(period)) {

            return new ModelMap();
        }

        System.out.println(period);

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(FORM_ACTION, DASHBOARD_PATH);

        String title = messageProvider.getMessage(DASHBOARD_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute("objectiveUrl", OBJECTIVE_PATH);

        modelMap.addAttribute("categoryUrl", CATEGORY_PATH);

        modelMap.addAttribute("budgetUrl",
            fillPath(BUDGET_PATH, ID_PATH_VARIABLE, 1));

        modelMap.addAttribute("cashFlowUrl",
            fillPath(CASH_FLOW_PATH, ID_PATH_VARIABLE, 1));

        return modelMap;
    }

}
