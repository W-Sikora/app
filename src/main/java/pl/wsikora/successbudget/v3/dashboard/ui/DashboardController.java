package pl.wsikora.successbudget.v3.dashboard.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static pl.wsikora.successbudget.v3.common.Constants.DASHBOARD_PATH;


@Controller
@RequestMapping(DASHBOARD_PATH)
public class DashboardController {

    private static final String DASHBOARD_VIEW = "dashboard/dashboard";

    private final DashboardControllerDataProvider dashboardControllerDataProvider;

    private DashboardController(DashboardControllerDataProvider dashboardControllerDataProvider) {

        this.dashboardControllerDataProvider = dashboardControllerDataProvider;
    }

    @GetMapping
    private String view(Principal principal) {

        return DASHBOARD_VIEW;
    }

    @ModelAttribute
    private void data(Model model) {

        model.addAllAttributes(dashboardControllerDataProvider.provideData());
    }

}
