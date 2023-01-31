package pl.wsikora.successbudget.v3.user.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.ControllerUtils.getEditFormName;


@Controller
@RequestMapping(Constant.LOGIN_URL)
public class LoginController {

    @GetMapping
    private String goToView() {

        return EDIT_VIEW;
    }

    @ModelAttribute
    private void initData(@RequestParam(required = false) boolean invalid, ModelMap modelMap) {

        modelMap.addAttribute("invalid", invalid)
                .addAttribute(FORM_PAGE, getEditFormName(Constant.LOGIN))
                .addAttribute(PAGE_TITLE, "Logowanie");
    }
}
