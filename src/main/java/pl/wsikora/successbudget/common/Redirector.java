package pl.wsikora.successbudget.common;

import org.springframework.util.Assert;


public class Redirector {

    private static final String REDIRECT_PATTERN = "redirect:%s";

    private Redirector() {

    }

    public static String redirect(String path) {

        Assert.hasText(path, "path must not be empty");

        return String.format(REDIRECT_PATTERN, path);
    }
}
