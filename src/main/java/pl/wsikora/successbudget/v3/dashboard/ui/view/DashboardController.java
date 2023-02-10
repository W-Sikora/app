package pl.wsikora.successbudget.v3.dashboard.ui.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.Objects.nonNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.DASHBOARD_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(DASHBOARD_PATH)
public class DashboardController {

    private static final String DASHBOARD_VIEW = "dashboard/dashboard";

    private final DashboardControllerDataProvider dashboardControllerDataProvider;

    private DashboardController(DashboardControllerDataProvider dashboardControllerDataProvider) {

        this.dashboardControllerDataProvider = dashboardControllerDataProvider;
    }

    @GetMapping
    private String view(@RequestParam(required = false) String period) {

        if (nonNull(period)) {

            return redirect(DASHBOARD_PATH);
        }

        return DASHBOARD_VIEW;
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) String period, Model model) {

        model.addAllAttributes(dashboardControllerDataProvider.provideData(period));
    }

}
