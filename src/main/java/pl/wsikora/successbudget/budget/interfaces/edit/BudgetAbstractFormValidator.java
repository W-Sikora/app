//package pl.wsikora.successbudget.budget.interfaces.edit;
//
//import org.springframework.validation.Errors;
//import pl.wsikora.budget.common.abstractutil.interfaces.AbstractFormValidator;
//
//import static org.springframework.util.StringUtils.hasText;
//import static pl.wsikora.budget.budget.interfaces.edit.BudgetForm.F_NAME;
//
//public class BudgetAbstractFormValidator extends AbstractFormValidator<BudgetForm> {
//
//    protected BudgetAbstractFormValidator(Class<BudgetForm> budgetFormClass) {
//
//        super(budgetFormClass);
//    }
//
//    @Override
//    protected void validateForm(BudgetForm budgetForm, Errors errors) {
//
//        if (!hasText(budgetForm.getName())) {
//
//            errors.rejectValue(F_NAME, "");
//        }
//    }
//}
