package pl.wsikora.successbudget.v3.landing.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static pl.wsikora.successbudget.v3.common.Constants.SLASH;


@Controller
@RequestMapping(SLASH)
public class LandingViewController {

    private static final String VIEW = "landing/landing-page";

    private final LandingViewControllerDataProvider landingViewControllerDataProvider;

    private LandingViewController() {

        this.landingViewControllerDataProvider = new LandingViewControllerDataProvider();
    }

    @GetMapping
    private String landingView() {

        return VIEW;
    }

    @ModelAttribute
    private void data(Model model) {

        model.addAllAttributes(landingViewControllerDataProvider.provideData());
    }

}
