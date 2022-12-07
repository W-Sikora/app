package pl.wsikora.successbudget.common;

import org.springframework.util.Assert;


public class Redirector {

    private static final String REDIRECT_PATTERN = "redirect:%s";
    private static final String REDIRECT_WITH_QUERY_PARAMETER_PATTERN = REDIRECT_PATTERN + "?%s=%s";

    private Redirector() {

    }

    public static String redirect(String path) {

        Assert.hasText(path, "path must not be empty");

        return String.format(REDIRECT_PATTERN, path);
    }

    public static String redirectWithQueryParameter(String path, String queryParameterName, Object queryParameterValue) {

        Assert.hasText(path, "path must not be empty");
        Assert.hasText(queryParameterName, "queryParameterName must not be empty");
        Assert.notNull(queryParameterValue, "queryParameterValue must not be null");

        return String.format(REDIRECT_WITH_QUERY_PARAMETER_PATTERN, path, queryParameterName, queryParameterValue);
    }
}
