package pl.wsikora.successbudget.v3.common;

public class ControllerUtils {

    private static final String EDIT_FORM_FORMAT = "../forms/%s-form.jsp";

    private ControllerUtils() {}

    public static String getEditFormName(String pathName) {

        return String.format(EDIT_FORM_FORMAT, pathName);
    }
}
