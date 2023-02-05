package pl.wsikora.successbudget.v3.common.util;

import org.springframework.util.Assert;


public class ControllerUtils {

    private static final String EDIT_FORM_FORMAT = "../forms/%s-form.jsp";
    private static final String LIST_FORMAT = "../lists/%s-list.jsp";
    private static final String STEP_FORMAT = "../steps/step%d.jsp";

    private ControllerUtils() {}

    public static String getEditFormName(String pathName) {

        Assert.hasText(pathName, "pathName must not be empty");

        return String.format(EDIT_FORM_FORMAT, pathName);
    }

    public static String getListName(String pathName) {

        Assert.hasText(pathName, "pathName must not be empty");

        return String.format(LIST_FORMAT, pathName);
    }

    public static String getStep(int step) {

        return String.format(STEP_FORMAT, step);
    }
}
