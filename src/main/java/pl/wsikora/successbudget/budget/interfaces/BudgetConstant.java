package pl.wsikora.successbudget.budget.interfaces;

public class BudgetConstant {

    public static final String BUDGET_VIEW = "administration-view";
    public static final String BUDGET_VIEW_URL = "/budgets";
    public static final String BUDGET_EDIT_VIEW = "administration-edit-view";
    public static final String BUDGET_EDIT_URL = BUDGET_VIEW_URL + "/edit";
    public static final String BUDGET_DELETE_URL = BUDGET_VIEW_URL + "/delete/{id}";

    private BudgetConstant() {

    }
}
