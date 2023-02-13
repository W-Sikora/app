package pl.wsikora.successbudget.v3.common.util;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.util.StringUtils.hasText;


public class StringUtils {

    public static final String SLASH = "/";
    public static final String DASH = "-";
    public static final String LEFT_CURLY_BRACKETS = "{";
    public static final String RIGHT_CURLY_BRACKETS = "}";

    public static String convertToLowerCase(@Nullable String string) {

        return hasText(string) ? string.toLowerCase() : null;
    }

    public static String formAttributeNameCamelCase(String... parts) {

        Assert.notEmpty(parts, "parts must not be empty");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {

            String part = parts[i];

            if (i == 0 && part.contains(DASH)) {

                String[] splitParts = part.split(DASH);

                part = splitParts[0]
                    .concat(splitParts[1].substring(0, 1).toUpperCase())
                    .concat(splitParts[1].substring(1));
            }
            else if (i > 0) {

                part = capitalizeFirst(part);
            }
            result.append(part);
        }

        return result.toString();
    }

    private static String capitalizeFirst(String str) {

        return str.substring(0, 1).toUpperCase().concat(str.substring(1));
    }

    public static String fillPath(String path, String elementToFill, Object valueToFill) {

        return path.replace(elementToFill, EMPTY + valueToFill);
    }

}
