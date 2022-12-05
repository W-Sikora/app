//package pl.wsikora.successbudget.budget.interfaces.edit;
//
//import org.springframework.stereotype.Service;
//import pl.wsikora.budget.budget.application.BudgetQueries;
//import pl.wsikora.budget.budget.domain.Budget;
//import pl.wsikora.budget.common.abstractutil.domain.AbstractEntity;
//import pl.wsikora.budget.common.abstractutil.interfaces.AbstractFormFactory;
//
//import java.util.List;
//
//@Service
//class BudgetFormFactory extends AbstractFormFactory<BudgetQueries, Budget, BudgetForm> {
//
//    private BudgetFormFactory(BudgetQueries budgetQueries) {
//
//        super(budgetQueries);
//    }
//
//    @Override
//    public BudgetForm convertToForm(Budget budget) {
//
//        BudgetForm form = new BudgetForm();
//
//        form.setId(budget.getId());
//
//        form.setName(budget.getName());
//
//        Long creatorId = budget.getCreator().getId();
//        form.setCreatorId(creatorId);
//
//        List<Long> ownersId = budget.getOwners()
//                .stream()
//                .map(AbstractEntity::getId)
//                .toList();
//
//        form.setOwnersId(ownersId);
//
//        return form;
//    }
//}
