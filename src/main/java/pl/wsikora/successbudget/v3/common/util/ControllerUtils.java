package pl.wsikora.successbudget.v3.common.util;

import org.springframework.util.Assert;


public class ControllerUtils {

    private static final String EDIT_FORM_VIEW_FORMAT = "../forms/%s-form.jsp";
    private static final String LIST_VIEW_FORMAT = "../lists/%s-list.jsp";
    private static final String COMMON_VIEW_FORMAT = "../common/%s.jsp";

    private ControllerUtils() {}

    public static String getEditFormViewName(String name) {

        return getViewName(EDIT_FORM_VIEW_FORMAT, name);
    }

    public static String getListViewName(String name) {

        return getViewName(LIST_VIEW_FORMAT, name);
    }

    public static String getCommonViewName(String name) {

        return getViewName(COMMON_VIEW_FORMAT, name);
    }

    private static String getViewName(String format, String name) {

        Assert.hasText(format, "format must not be empty");
        Assert.hasText(name, "name must not be empty");

        return String.format(format, name);
    }

}
