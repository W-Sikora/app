package pl.wsikora.successbudget.v3.common.util;

import org.springframework.util.Assert;


public class StringUtils {

    public static final String EMPTY = "";
    public static final String SLASH = "/";
    public static final String DASH = "-";
    public static final String LEFT_CURLY_BRACKETS = "{";
    public static final String RIGHT_CURLY_BRACKETS = "}";

    public static String formAttributeNameCamelCase(String... parts) {

        Assert.notEmpty(parts, "parts must not be empty");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {

            String part = parts[i];

            if (part.contains(DASH)) {

                String[] splitParts = part.split(DASH);

                String splitPart = splitParts[1];

                part = splitParts[0].concat(splitPart.substring(0, 1).toUpperCase())
                    .concat(splitPart.substring(1));
            }

            if (i == 0) {

                result.append(part);
            }

            result.append(part.substring(0, 1).toUpperCase())
                .append(part.substring(1));
        }

        return result.toString();
    }

    public static String fillPath(String path, String elementToFill, Object valueToFill) {

        return path.replace(elementToFill, EMPTY + valueToFill);
    }

}
