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

    private final DashboardViewControllerDataProvider dataProvider;

    private DashboardViewController(DashboardViewControllerDataProvider dataProvider) {

        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view() {

        return DASHBOARD_VIEW;
    }

    @ModelAttribute
    private void data(DashboardViewParameters parameters, HttpSession session, Model model) {

        model.addAllAttributes(dataProvider.provideData(parameters, session));
    }

}
