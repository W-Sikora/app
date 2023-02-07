package pl.wsikora.successbudget.v3.landing.ui;

import org.springframework.ui.ModelMap;

import static pl.wsikora.successbudget.v3.common.Constants.*;


class LandingViewControllerDataProvider {

    ModelMap provideData() {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, SLASH);

        modelMap.addAttribute(REGISTRATION, REGISTRATION_PATH);

        modelMap.addAttribute(LOGIN, LOGIN_PATH);

        return modelMap;
    }

}
