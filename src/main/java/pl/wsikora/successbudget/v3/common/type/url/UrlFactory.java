package pl.wsikora.successbudget.v3.common.type.url;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;


public class UrlFactory {

    private static final String PATH_VARIABLE_PATTERN = "(\\{[^}]{2,}})";

    private UrlFactory() {}

    public static String createPath(String path, @Nullable Long... identifiers) {

        Assert.hasText(path, "path must not be empty");

        String replacedPath = createReplacedPath(path);

        return String.format(replacedPath, (Object[]) identifiers);
    }

    private static String createReplacedPath(String path) {

        return path.replaceAll(PATH_VARIABLE_PATTERN, "%s");
    }

}
