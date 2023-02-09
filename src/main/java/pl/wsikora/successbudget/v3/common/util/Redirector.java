package pl.wsikora.successbudget.v3.common.util;

import org.springframework.util.Assert;

import static pl.wsikora.successbudget.v3.common.Constants.SLASH;


public class Redirector {

    private static final String REDIRECT_PATTERN = "redirect:%s";
    private static final String REDIRECT_WITH_QUERY_PARAMETER_PATTERN = REDIRECT_PATTERN + "%s";
    private static final String REDIRECT_WITH_PARTICULAR_QUERY_PARAMETER_PATTERN = REDIRECT_PATTERN + "?%s=%s";

    private Redirector() {}

    public static String redirect(String path) {

        Assert.hasText(path, "path must not be empty");

        return String.format(REDIRECT_PATTERN, path);
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
