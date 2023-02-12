package pl.wsikora.successbudget.v3.common.ui.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;


@Controller
@RequestMapping("/errors")
class CommonErrorController implements ErrorController {

    private final CommonErrorControllerDataProvider commonErrorControllerDataProvider;

    private CommonErrorController() {

        this.commonErrorControllerDataProvider = new CommonErrorControllerDataProvider();
    }

    @GetMapping
    private String handleError() {

        return VIEW;
    }

    @ModelAttribute
    private void data(HttpServletRequest request, Model model) {

        model.addAllAttributes(commonErrorControllerDataProvider.provideData(request));
    }

}
