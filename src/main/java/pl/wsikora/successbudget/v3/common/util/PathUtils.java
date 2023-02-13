package pl.wsikora.successbudget.v3.common.util;

import java.time.YearMonth;


public class PathUtils {

    private static final String PATTERN = "%s?period=%s";

    private PathUtils() {}

    public static String pathWithPeriod(String path, YearMonth period) {

        return String.format(PATTERN, path, period);
    }

}
