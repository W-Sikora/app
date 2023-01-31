package pl.wsikora.successbudget.v3.common;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.util.Objects.isNull;


@Controller
@RequestMapping("/errors")
class CommonErrorController implements ErrorController {

    private static final String VIEW = "common/error-page";

    @GetMapping
    private String handleError() {

        return VIEW;
    }

    @ModelAttribute
    private void initData(HttpServletRequest request, ModelMap modelMap) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (isNull(status)) {

            modelMap.addAttribute("errorMessage", "unknown.error.message");

            return;
        }

        int statusCode = (Integer) status;

        modelMap.addAttribute("errorCode", statusCode)
                .addAttribute("errorMessage", "error.message." + statusCode);
    }
}
