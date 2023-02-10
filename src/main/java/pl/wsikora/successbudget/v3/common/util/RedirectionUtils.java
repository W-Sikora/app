package pl.wsikora.successbudget.v3.common.util;

import org.springframework.util.Assert;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.SLASH;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.fillPath;


public class RedirectionUtils {

    private static final String REDIRECT_PATTERN = "redirect:%s";
    private static final String REDIRECT_WITH_QUERY_PARAMETER_PATTERN = REDIRECT_PATTERN + "%s";
    private static final String REDIRECT_WITH_PARTICULAR_QUERY_PARAMETER_PATTERN = REDIRECT_PATTERN + "?%s=%s";

    private RedirectionUtils() {}

    public static String redirect(String path) {

        Assert.hasText(path, "path must not be empty");

        return String.format(REDIRECT_PATTERN, path);
    }

    public static String redirect(String path, Object value) {

        Assert.hasText(path, "path must not be empty");
        Assert.notNull(value, "value must not be empty");

        String finalPath;

        if (path.contains(ID_PATH_VARIABLE)) {

            finalPath = fillPath(path, ID_PATH_VARIABLE, value);
        }
        else if (path.contains(BUDGET_ID_PATH_VARIABLE)) {

            finalPath = fillPath(path, BUDGET_ID_PATH_VARIABLE, value);
        }
        else if (path.contains(CASH_FLOW_ID_PATH_VARIABLE)) {

            finalPath = fillPath(path, CASH_FLOW_ID_PATH_VARIABLE, value);
        }
        else {

            finalPath = path;
        }

        return String.format(REDIRECT_PATTERN, finalPath);
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
