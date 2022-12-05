package pl.wsikora.successbudget.language.interfaces;

public class LanguageConstant {

    public static final String LANGUAGE_VIEW = "administration-view";
    public static final String LANGUAGE_VIEW_URL = "/languages";
    public static final String LANGUAGE_EDIT_VIEW = "administration-edit-view";
    public static final String LANGUAGE_EDIT_URL = LANGUAGE_VIEW_URL + "/edit";
    public static final String LANGUAGE_DELETE_URL = LANGUAGE_VIEW_URL + "/delete/{id}";

    private LanguageConstant() {

    }
}
