package pl.wsikora.successbudget.v3.common;

public class ViewControllerUtils {

    private static final String LIST_PAGE_FORMAT = "../lists/%s.jsp";

    private ViewControllerUtils() {

    }

    public static String getListPageName(String entityName) {

        return String.format(LIST_PAGE_FORMAT, entityName);
    }

}
