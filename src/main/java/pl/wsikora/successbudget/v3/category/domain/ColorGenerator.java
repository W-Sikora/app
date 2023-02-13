package pl.wsikora.successbudget.v3.category.domain;

import static org.apache.commons.lang3.RandomUtils.nextInt;


class ColorGenerator {

    static final int MAXIMUM_LENGTH = 45;

    private static final String PATTERN = "rgba(%d, %d, %d, %s)";
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 255;

    static String newColor() {

        int red = nextInt(MINIMUM_VALUE, MAXIMUM_VALUE);
        int green = nextInt(MINIMUM_VALUE, MAXIMUM_VALUE);
        int blue = nextInt(MINIMUM_VALUE, MAXIMUM_VALUE);
        String alpha = "0.5";

        return String.format(PATTERN, red, green, blue, alpha);
    }

}
