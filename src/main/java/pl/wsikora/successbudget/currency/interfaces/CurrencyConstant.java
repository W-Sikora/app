package pl.wsikora.successbudget.currency.interfaces;

public class CurrencyConstant {

    public static final String CURRENCY_VIEW = "administration-view";
    public static final String CURRENCY_VIEW_URL = "/currencies";
    public static final String CURRENCY_EDIT_VIEW = "administration-edit-view";
    public static final String CURRENCY_EDIT_URL = CURRENCY_VIEW_URL + "/edit";
    public static final String CURRENCY_DELETE_URL = CURRENCY_VIEW_URL + "/delete/{id}";

    private CurrencyConstant() {

    }
}
