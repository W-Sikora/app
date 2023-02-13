package pl.wsikora.successbudget.v3.dashboard.ui.view;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import java.time.YearMonth;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;


@Service
class DashboardControllerDataProvider {

    private final MessageProvider messageProvider;

    private DashboardControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData(YearMonth period, HttpSession session) {

        Assert.notNull(session, "session must not be null");

        if (isNull(period)) {

            period = YearMonth.now();

            session.setAttribute(PERIOD, period);
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
