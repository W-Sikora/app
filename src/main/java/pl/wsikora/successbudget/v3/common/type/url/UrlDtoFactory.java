package pl.wsikora.successbudget.v3.common.type.url;

import org.springframework.util.Assert;


public class UrlDtoFactory {

    private static final String PATH_VARIABLE_PATTERN = "(\\{[^}]{2,}})";

    private UrlDtoFactory() {}

    public static UrlDto create(String editPath, String deletePath, Long... identifiers) {

        Assert.hasText(editPath, "editPath must not be empty");
        Assert.hasText(deletePath, "deletePath must not be empty");
        Assert.notEmpty(identifiers, "identifiers must not be empty");

        return new UrlDto(
            createPath(editPath, identifiers),
            createPath(deletePath, identifiers)
        );
    }

    private static String createPath(String editPath, Long... identifiers) {

        int length = identifiers.length;

        Assert.isTrue(hasValidLength(length), "number of identifiers must be between 1 and 2");

        String replacedPath = createReplacedPath(editPath);

        return String.format(replacedPath, (Object[]) identifiers);
    }

    private static boolean hasValidLength(int length) {

        return length > 0 && length < 3;
    }

    private static String createReplacedPath(String path) {

        return path.replaceAll(PATH_VARIABLE_PATTERN, "%s");
    }

}
