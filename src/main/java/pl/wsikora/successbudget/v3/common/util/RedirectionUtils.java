package pl.wsikora.successbudget.v3.common.util;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.Assert;

import static pl.wsikora.successbudget.v3.common.type.url.UrlFactory.createPath;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.SessionUtils.getPeriod;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.SLASH;


public class RedirectionUtils {

    private static final String REDIRECT_PATTERN = "redirect:%s";
    private static final String REDIRECT_WITH_QUERY_PARAMETER_PATTERN = REDIRECT_PATTERN + "%s";
    private static final String REDIRECT_WITH_PARTICULAR_QUERY_PARAMETER_PATTERN = REDIRECT_PATTERN + "?%s=%s";

    private RedirectionUtils() {}

    public static String redirect(String path) {

        Assert.hasText(path, "path must not be empty");

        return String.format(REDIRECT_PATTERN, path);
    }

    public static String redirect(String path, Long value) {

        Assert.hasText(path, "path must not be empty");
        Assert.notNull(value, "value must not be empty");

        return createPath(path, value);
    }

    public static String redirectToBudgetPath(HttpSession session) {

        return redirectWithQueryParameter(BUDGET_PATH, PERIOD, getPeriod(session));
    }

    public static String redirectToCashFlowPath(HttpSession session) {

        return redirectWithQueryParameter(CASH_FLOW_PATH, PERIOD, getPeriod(session));
    }



    public static String redirect(Object... paths) {

        Assert.notEmpty(paths, "paths must not be empty");

        StringBuilder finalPath = new StringBuilder();

        for (Object path : paths) {

            finalPath.append(path).append(SLASH);
        }

        return String.format(REDIRECT_PATTERN, finalPath);
    }

    public static String redirectWithQueryParameter(String pathWithQueryParameter, Object queryParameterValue) {

        Assert.hasText(pathWithQueryParameter, "pathWithQueryParameter must not be empty");
        Assert.notNull(queryParameterValue, "queryParameterValue must not be null");

        return String.format(REDIRECT_WITH_QUERY_PARAMETER_PATTERN, pathWithQueryParameter, queryParameterValue);
    }

    public static String redirectWithQueryParameter(String path, String queryParameterName, Object queryParameterValue) {

        Assert.hasText(path, "path must not be empty");
        Assert.hasText(queryParameterName, "queryParameterName must not be empty");
        Assert.notNull(queryParameterValue, "queryParameterValue must not be null");

        return String.format(REDIRECT_WITH_PARTICULAR_QUERY_PARAMETER_PATTERN, path, queryParameterName, queryParameterValue);
    }
}
