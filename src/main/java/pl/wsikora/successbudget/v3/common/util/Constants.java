package pl.wsikora.successbudget.v3.common.util;

import static pl.wsikora.successbudget.v3.common.util.StringUtils.*;


public class Constants {

    public static final String USER_ROLE = "USER";

    public static final String STATIC_RESOURCES_PATH = "/static/**";
    public static final String WEB_INF_RESOURCES_PATH = "/WEB-INF/**";

    public static final String USERNAME_PARAMETER = "username";
    public static final String PASSWORD_PARAMETER = "password";

    public static final String EDIT_PATH = "/edit";
    public static final String CREATE_PATH = "/create";
    public static final String DELETE_PATH = "/delete/";
    public static final String COMPLETED_PATH = "/completed";
    public static final String ID_PATH_VARIABLE = "{id}";
    public static final String ID_PATH_QUERY = "?id=";

    public static final String FORM_ACTION = "formAction";
    public static final String FORM_SUFIX = "Form";
    public static final String FORM_PAGE = "formPage";
    public static final String FORM = "form";

    public static final String VIEW = "common/view";
    public static final String PAGE_PATH = "pagePath";
    public static final String COLUMN_SIZE = "columnSize";
    public static final String PAGE_TITLE = "pageTitle";
    public static final String BREADCRUMB_ELEMENTS = "breadcrumbElements";
    public static final String LOGO_APP_URL = "logoAppUrl";

    public static final String ADD_URL = "addUrl";
    public static final String EDIT_URL = "editUrl";
    public static final String DELETE_URL = "deleteUrl";

    public static final String KEYWORD = "keyword";

    public static final String LOGOUT_PATH = "/logout";


    // Pagination
    public static final int DEFAULT_PAGINATION_PAGE = 0;
    public static final int DEFAULT_PAGINATION_SIZE = 15;
    public static final String CURRENT_PAGE = "currentPage";

    // Sizes
    public static final int FORM_PAGE_SIZE = 5;

    // Paths
    public static final String LANDING_PAGE_PATH = "/";
    public static final String I18N_PATH = "/locale";
    public static final String REGISTRATION_PATH = "/registration";
    public static final String LOGIN_PATH = "/login";
    public static final String MAJOR_CURRENCY = "major-currency";
    public static final String MAJOR_CURRENCY_EDIT_PATH = "/major-currency/edit";
    public static final String DASHBOARD_PATH = "/dashboards/";
    public static final String OBJECTIVE_PATH = "/objectives";
    public static final String OBJECTIVE_ADD_PATH = "/objectives/edit";
    public static final String OBJECTIVE_EDIT_PATH = "/objectives/edit?objectiveId={objectiveId}";
    public static final String CATEGORY_PATH = "/categories";
    public static final String CATEGORY_ADD_PATH = "/categories/edit";
    public static final String CATEGORY_EDIT_PATH = "/categories/edit?categoryId={categoryId}";
    public static final String CATEGORY_DELETE_PATH = "/categories/delete/{categoryId}";
    public static final String BUDGET_PATH = "/budgets/{budgetId}";
    public static final String PLANNED_EXPENDITURE_ADD_PATH = "/budgets/{budgetId}/planned-expenditures/edit";
    public static final String PLANNED_EXPENDITURE_EDIT_PATH = "/budgets/{budgetId}/planned-expenditures/edit?revenueId={revenueId}";
    public static final String PLANNED_EXPENDITURE_DELETE_PATH = "/budgets/{budgetId}/planned-expenditures/delete/{plannedExpenditureId}";
    public static final String PLANNED_REVENUE_ADD_PATH = "/budgets/{budgetId}/planned-revenues/edit";
    public static final String PLANNED_REVENUE_EDIT_PATH = "/budgets/{budgetId}/planned-revenues/edit?plannedRevenueId={plannedRevenueId}";
    public static final String PLANNED_REVENUE_DELETE_PATH = "/budgets/{budgetId}/planned-revenues/delete/{plannedRevenueId}";
    public static final String CASH_FLOW_PATH = "/cash-flows/{cashFlowId}";
    public static final String EXPENDITURE_PATH = "/cash-flows/{cashFlowId}/expenditures/";
    public static final String EXPENDITURE_ADD_PATH = "/cash-flows/{cashFlowId}/expenditures/edit";
    public static final String EXPENDITURE_EDIT_PATH = "/cash-flows/{cashFlowId}/expenditures/edit?expenditureId={expenditureId}";
    public static final String EXPENDITURE_DELETE_PATH = "/cash-flows/{cashFlowId}/expenditures/delete/{expenditureId}";
    public static final String REVENUE_ADD_PATH = "/cash-flows/{cashFlowId}/revenues/edit";
    public static final String REVENUE_EDIT_PATH = "/cash-flows/{cashFlowId}/revenues/edit?revenueId={revenueId}";
    public static final String REVENUE_DELETE_PATH = "/cash-flows/{cashFlowId}/revenues/delete/{revenueId}";
    public static final String NO_RESOURCE_PATH = "no-resource";


    // error
    public static final String ERROR = "error";

    // no resource
    public static final String NO_RESOURCE = "no-resource";

    public static final String LANDING_PAGE_TITLE = "landing.page.title";


    // Registration
    public static final String REGISTRATION = "registration";


    // Login
    public static final String LOGIN = "login";
    public static final String LOGIN_FAILURE_PATH = LOGIN_PATH + "?invalid=true";


    // Dashboard
    public static final String DASHBOARD_TITLE = "dashboard.title";


    // Objective
    public static final String OBJECTIVE = "objective";
    public static final String OBJECTIVE_COMPLETED_PATH = OBJECTIVE_PATH + COMPLETED_PATH;
    public static final String OBJECTIVE_LIST_TITLE = "objective.list.page.title";
    public static final String OBJECTIVE_ADD_TITLE = "objective.add.page.title";
    public static final String OBJECTIVE_EDIT_TITLE = "objective.edit.page.title";


    // Category
    public static final String CATEGORY = "category";
    public static final String CATEGORY_LIST_TITLE = "category.list.page.title";
    public static final String CATEGORY_ADD_TITLE = "category.add.page.title";
    public static final String CATEGORY_EDIT_TITLE = "category.edit.page.title";


    // Budget
    public static final String BUDGET = "budget";
    public static final String BUDGET_PARTICULAR_PATH = BUDGET_PATH + ID_PATH_QUERY;
    public static final String BUDGET_TITLE = "budget";
    public static final String BUDGET_ID = "budgetId";
    public static final String BUDGET_ID_PATH_VARIABLE = LEFT_CURLY_BRACKETS + BUDGET_ID + RIGHT_CURLY_BRACKETS;

    public static final String CASH_FLOW_ID = "cashFlowId";
    public static final String CASH_FLOW_ID_PATH_VARIABLE = LEFT_CURLY_BRACKETS + CASH_FLOW_ID + RIGHT_CURLY_BRACKETS;

    // PlannedExpenditure
    public static final String PLANNED_EXPENDITURE = "planned-expenditure";
    public static final String PLANNED_EXPENDITURE_ADD_TITLE = "planned.expenditure.add.page.title";
    public static final String PLANNED_EXPENDITURE_EDIT_TITLE = "planned.expenditure.edit.page.title";


    // PlannedRevenue
    public static final String PLANNED_REVENUE = "planned-revenue";

    public static final String PLANNED_REVENUE_LIST_TITLE = "planned.revenue.list.page.title";
    public static final String PLANNED_REVENUE_ADD_TITLE = "planned.revenue.add.page.title";
    public static final String PLANNED_REVENUE_EDIT_TITLE = "planned.revenue.edit.page.title";


    // CashFlow
    public static final String CASH_FLOW = "cash-flow";
    public static final String CASH_FLOW_TITLE = "cash.flow";


    // Expenditure
    public static final String EXPENDITURE = "expenditure";

    public static final String EXPENDITURE_LIST_TITLE = "expenditure.list.page.title";
    public static final String EXPENDITURE_ADD_TITLE = "expenditure.add.page.title";
    public static final String EXPENDITURE_EDIT_TITLE = "expenditure.edit.page.title";


    // Revenue
    public static final String REVENUE = "revenue";
    public static final String REVENUE_PATH = "/revenues";

    public static final String REVENUE_LIST_TITLE = "revenue.list.page.title";
    public static final String REVENUE_ADD_TITLE = "revenue.add.page.title";
    public static final String REVENUE_EDIT_TITLE = "revenue.edit.page.title";

}
