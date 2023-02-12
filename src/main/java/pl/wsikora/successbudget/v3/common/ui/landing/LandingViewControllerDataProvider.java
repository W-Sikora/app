package pl.wsikora.successbudget.v3.common.ui.landing;

import org.springframework.ui.ModelMap;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


class LandingViewControllerDataProvider {

    ModelMap provideData() {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, LANDING_PAGE_PATH);

        modelMap.addAttribute(REGISTRATION, REGISTRATION_PATH);

        modelMap.addAttribute(LOGIN, LOGIN_PATH);

        return modelMap;
    }

}
