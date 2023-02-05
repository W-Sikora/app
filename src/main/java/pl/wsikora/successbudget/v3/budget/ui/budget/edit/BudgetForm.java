package pl.wsikora.successbudget.v3.budget.ui.budget.edit;

import lombok.Getter;
import lombok.Setter;

import java.time.YearMonth;


@Setter
@Getter
public class BudgetForm {

    static final String F_YEAR_MONTH = "yearMonth";

    private Long budgetId;
    private YearMonth yearMonth;
    private String owner;

}
