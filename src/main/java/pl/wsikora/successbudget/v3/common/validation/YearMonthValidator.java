package pl.wsikora.successbudget.v3.common.validation;

import java.time.YearMonth;

import static org.springframework.util.StringUtils.hasText;


public class YearMonthValidator {

    private YearMonthValidator() {}

    public static boolean isValid(String period) {

        if (!hasText(period)) {

            return false;
        }

        try {

            YearMonth.parse(period);
        } catch (Exception e) {

            return false;
        }

        return true;
    }

}
