package pl.wsikora.successbudget.plannedtransaction.application.command;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.common.TransactionType;
import pl.wsikora.successbudget.plannedtransaction.domain.PlannedTransaction;

import java.util.Optional;


@Service
public class PlannedTransactionCommandService {

    private final PlannedTransactionCommand plannedTransactionCommand;

    private PlannedTransactionCommandService(PlannedTransactionCommand plannedTransactionCommand) {

        this.plannedTransactionCommand = plannedTransactionCommand;
    }

    public void save(PlannedTransactionFormAttribute attribute) {

        Assert.notNull(attribute, "attribute must not be null");

        PlannedTransaction plannedTransaction = convert(attribute);

        plannedTransactionCommand.save(plannedTransaction);
    }

    public void delete(long id) {

        plannedTransactionCommand.delete(id);
    }

    private PlannedTransaction convert(PlannedTransactionFormAttribute attribute) {

        PlannedTransaction plannedTransaction = new PlannedTransaction();

        plannedTransaction.setId(attribute.getId());

        plannedTransaction.setBudgetId(attribute.getId());

        plannedTransaction.setName(attribute.getName());

        Optional<TransactionType> transactionType = TransactionType.findById(attribute.getTransactionTypeId());

//        plannedTransaction.setTransactionType();

        plannedTransaction.setParentCategoryId(attribute.getParentCategoryId());

        plannedTransaction.setCategoryId(attribute.getCategoryId());

        plannedTransaction.setValue(attribute.getValue());

        plannedTransaction.setCurrencyId(attribute.getCurrencyId());

        plannedTransaction.setCreatedByUserId(attribute.getCreatedByUserId());

        plannedTransaction.setCycleValue(attribute.getCycleValue());

        plannedTransaction.setAccountingPeriod(attribute.getAccountingPeriod());

        return plannedTransaction;
    }
}
