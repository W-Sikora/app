package pl.wsikora.successbudget.v3.dashboard.ui.view;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;
import pl.wsikora.successbudget.v3.common.validation.YearMonthValidator;

import static java.util.Objects.nonNull;
import static pl.wsikora.successbudget.v3.common.Constants.*;


@Service
class DashboardControllerDataProvider {

    private final MessageProvider messageProvider;

    private DashboardControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData(String period) {

        if (nonNull(period) && !YearMonthValidator.isValid(period)) {

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

        modelMap.addAttribute("budgetUrl", BUDGET_PATH);

        modelMap.addAttribute("cashFlowUrl", CASH_FLOW_PATH);

        return modelMap;
    }

}
