package pl.wsikora.successbudget.v3.common.util;

import jakarta.servlet.http.HttpSession;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.PERIOD;


public class SessionUtils {

    private SessionUtils() {}

    public static YearMonth getPeriod(HttpSession session) {

        return  (YearMonth) session.getAttribute(PERIOD);
    }

}
