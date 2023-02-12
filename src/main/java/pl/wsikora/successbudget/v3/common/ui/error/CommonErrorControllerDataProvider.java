package pl.wsikora.successbudget.v3.common.ui.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;

import static java.util.Objects.nonNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getCommonViewName;


class CommonErrorControllerDataProvider {

    ModelMap provideData(HttpServletRequest request) {

        Assert.notNull(request, "request must not be null");

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(COLUMN_SIZE, FORM_PAGE_SIZE);

        modelMap.addAttribute(PAGE_PATH, getCommonViewName(ERROR));

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (nonNull(status)) {

            int statusCode = (Integer) status;

            modelMap.addAttribute(PAGE_TITLE, statusCode);

            modelMap.addAttribute("errorMessage", "error.message." + statusCode);

            return modelMap;
        }

        modelMap.addAttribute("errorMessage", "unknown.error.message");

        return modelMap;
    }

}
