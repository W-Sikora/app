//package pl.wsikora.successbudget.budget.interfaces.edit;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.wsikora.budget.budget.application.BudgetCommandService;
//import pl.wsikora.budget.common.abstractutil.interfaces.AbstractEditController;
//
//import static pl.wsikora.budget.common.util.Redirector.redirect;
//
//
//@Controller
//@RequestMapping("/budgets/edit")
//public class BudgetAbstractEditController extends AbstractEditController<BudgetForm> {
//
//    private final BudgetCommandService budgetCommandService;
//    private final BudgetFormFactory budgetFormFactory;
//
//    private BudgetAbstractEditController(BudgetCommandService budgetCommandService, BudgetFormFactory budgetFormFactory) {
//
//        super("");
//        this.budgetCommandService = budgetCommandService;
//        this.budgetFormFactory = budgetFormFactory;
//    }
//
//    @Override
//    protected BudgetForm getForm(Long id) {
//
//        return budgetFormFactory.createIfPresent(id)
//                .orElseGet(BudgetForm::new);
//    }
//
//    @Override
//    protected String save(BudgetForm form, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//
//            return goToView();
//        }
//
//        budgetCommandService.saveOrUpdate(form);
//
//        return redirect("/budgets");
//    }
//}
