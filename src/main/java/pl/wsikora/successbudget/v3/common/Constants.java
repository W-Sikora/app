package pl.wsikora.successbudget.v3.common;

public class Constants {

    public static final String SLASH = "/";
    public static final String EDIT_PATH = "/edit";
    public static final String DELETE_PATH = "/delete/";
    public static final String ID_PATH_VARIABLE = "{id}";
    public static final String ID_PATH_QUERY = "?id=";

    public static final String FORM_ACTION = "formAction";
    public static final String FORM_SUFIX = "Form";
    public static final String FORM_PAGE = "formPage";
    public static final String FORM = "form";
    public static final String PAGE_PATH = "pagePath";

    public static final String LIST_PAGE = "listPage";
    public static final String PAGE_TITLE = "pageTitle";

    public static final String BREADCRUMB_ELEMENTS = "breadcrumbElements";

    public static final String LANDING_PAGE_TITLE ="landing.page.title";

    public static final String REGISTRATION = "registration";
    public static final String REGISTRATION_FORM = REGISTRATION + FORM_SUFIX;
    public static final String REGISTRATION_PATH = SLASH + REGISTRATION;
    public static final String REGISTRATION_PAGE_TITLE = "registration.page.title";

    public static final String LOGIN = "login";
    public static final String LOGIN_PATH = SLASH + LOGIN;
    public static final String LOGIN_PAGE_TITLE = "login.page.title";

    public static final String ID = "id";


    public static final String CURRENTLY_LOGGED_IN_USER = "currentlyLoggedInUser";


    public static final String DASHBOARD_PATH = "/dashboards";
    public static final String DASHBOARD_TITLE = "dashboard.title";

    public static final String CATEGORY_PATH = "/categories";
    public static final String CATEGORY_EDIT_PATH = CATEGORY_PATH + EDIT_PATH;
    public static final String CATEGORY_DELETE_PATH = CATEGORY_PATH + DELETE_PATH;
    public static final String CATEGORY = "category";
    public static final String CATEGORY_FORM = CATEGORY + FORM_SUFIX;

    public static final String CATEGORY_LIST_TITLE = "category.list.page.title";
    public static final String CATEGORY_ADD_TITLE = "category.add.page.title";
    public static final String CATEGORY_EDIT_TITLE = "category.edit.page.title";

    public static final String VIEW = "common/view";

    public static final String DATA = "data";

    public static final String LOGO_APP_URL = "logoAppUrl";

}
