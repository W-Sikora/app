package pl.wsikora.successbudget.common.interfaces;

public class EditControllerUtils {

    private static final String EDIT_FORM_FORMAT = "forms/%s-form.jsp";

    private EditControllerUtils() {

    }

    public static String getEditFormName(String entityName) {

        return String.format(EDIT_FORM_FORMAT, entityName);
    }
}
