package pl.wsikora.successbudget.plannedtransaction.interfaces.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractFormFactory;
import pl.wsikora.successbudget.plannedtransaction.application.query.PlannedTransactionQuery;
import pl.wsikora.successbudget.plannedtransaction.domain.PlannedTransaction;

@Service
class PlannedTransactionFormFactory extends AbstractFormFactory<PlannedTransactionForm, PlannedTransaction> {

    private final PlannedTransactionQuery plannedTransactionQuery;

    private PlannedTransactionFormFactory(PlannedTransactionQuery plannedTransactionQuery) {

        this.plannedTransactionQuery = plannedTransactionQuery;
    }

    @Override
    public PlannedTransactionForm getForm(Long id) {

        if (id == null) {

            return new PlannedTransactionForm();
        }

        return convert(plannedTransactionQuery.getById(id));
    }

    @Override
    protected PlannedTransactionForm convert(PlannedTransaction plannedTransaction) {

        PlannedTransactionForm form = new PlannedTransactionForm();

        form.setId(plannedTransaction.getValue());

        form.setBudgetId(plannedTransaction.getBudgetId());

        form.setName(plannedTransaction.getName());

        form.setTransactionTypeId(plannedTransaction.getTransactionType().getId());

        form.setParentCategoryId(plannedTransaction.getParentCategoryId());

        form.setCategoryId(plannedTransaction.getCategoryId());

        form.setValue(plannedTransaction.getValue());

        form.setCurrencyId(plannedTransaction.getCurrencyId());

        form.setCreatedByUserId(plannedTransaction.getCreatedByUserId());

        form.setCycleValue(plannedTransaction.getCycleValue());

        form.setAccountingPeriod(plannedTransaction.getAccountingPeriod());

        return form;
    }
}
