package pl.wsikora.successbudget.v3.common.util;

import java.time.format.DateTimeFormatter;


public class DateFormatter {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter PERIOD_FORMATTER = DateTimeFormatter.ofPattern("MM-yyyy");

    private DateFormatter() {}

}
