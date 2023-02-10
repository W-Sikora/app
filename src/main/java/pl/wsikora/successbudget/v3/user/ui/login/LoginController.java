package pl.wsikora.successbudget.v3.user.ui.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static pl.wsikora.successbudget.v3.common.util.Constants.LOGIN_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;


@Controller
@RequestMapping(LOGIN_PATH)
class LoginController {

    private final LoginControllerDataProvider loginControllerDataProvider;

    private LoginController(LoginControllerDataProvider loginControllerDataProvider) {

        this.loginControllerDataProvider = loginControllerDataProvider;
    }

    @GetMapping
    private String goToView() {

        return VIEW;
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) boolean invalid, Model model) {

        model.addAllAttributes(loginControllerDataProvider.provideData(invalid));
    }

}
