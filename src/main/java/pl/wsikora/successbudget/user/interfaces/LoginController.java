package pl.wsikora.successbudget.user.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static pl.wsikora.successbudget.user.interfaces.Constant.LOGIN_URL;


@Controller
@RequestMapping(LOGIN_URL)
public class LoginController {

    private static final String VIEW = "landing/login-page";

    @GetMapping
    private String goToView() {

        return VIEW;
    }

    @ModelAttribute
    private void initData(@RequestParam(required = false) boolean invalid, ModelMap modelMap) {

        modelMap.addAttribute("invalid", invalid);
    }
}
