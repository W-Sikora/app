package pl.wsikora.successbudget.v3.user.ui.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static pl.wsikora.successbudget.v3.common.Constants.LOGIN_PATH;
import static pl.wsikora.successbudget.v3.common.Constants.VIEW;


@Controller
@RequestMapping(value = LOGIN_PATH)
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
