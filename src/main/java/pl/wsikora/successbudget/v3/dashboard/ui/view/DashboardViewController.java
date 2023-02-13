package pl.wsikora.successbudget.v3.dashboard.ui.view;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.DASHBOARD_PATH;


@Controller
@RequestMapping(DASHBOARD_PATH)
public class DashboardViewController {

    private static final String DASHBOARD_VIEW = "dashboard/dashboard";

    private final DashboardControllerDataProvider dashboardControllerDataProvider;

    private DashboardViewController(DashboardControllerDataProvider dashboardControllerDataProvider) {

        this.dashboardControllerDataProvider = dashboardControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return DASHBOARD_VIEW;
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) YearMonth period, HttpSession session, Model model) {

        model.addAllAttributes(dashboardControllerDataProvider.provideData(period, session));
    }

}
