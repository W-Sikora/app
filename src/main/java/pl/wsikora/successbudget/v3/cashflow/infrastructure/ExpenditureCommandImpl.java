package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowRepeatCommand;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureAttributes;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureCommand;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureDeleteCommand;
import pl.wsikora.successbudget.v3.cashflow.domain.CashFlow;
import pl.wsikora.successbudget.v3.cashflow.domain.Expenditure;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.payee.Payee;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;

import java.time.LocalDate;


@Service
class ExpenditureCommandImpl implements ExpenditureCommand {

    private final UsernameProvider usernameProvider;
    private final ExpenditureRepository expenditureRepository;
    private final CashFlowRepository cashFlowRepository;

    private ExpenditureCommandImpl(UsernameProvider usernameProvider,
                                   ExpenditureRepository expenditureRepository,
                                   CashFlowRepository cashFlowRepository) {

        this.usernameProvider = usernameProvider;
        this.expenditureRepository = expenditureRepository;
        this.cashFlowRepository = cashFlowRepository;
    }

    @Override
    public void save(ExpenditureAttributes expenditureAttributes) {

        Assert.notNull(expenditureAttributes, "expenditureAttributes must not be null");

        Expenditure expenditure = new Expenditure();

        expenditure.setExpenditureId(expenditureAttributes.getExpenditureId());

        CashFlow cashFlow = getCashFlowByCashFlowId(expenditureAttributes.getCashFlowId());

        expenditure.setCashFlow(cashFlow);

        expenditure.setOwner(usernameProvider.getUsername());

        CategoryId categoryId = new CategoryId(expenditureAttributes.getCategoryId());

        expenditure.setCategoryId(categoryId);

        Priority priority = Priority.of(expenditureAttributes.getPriority());

        expenditure.setPriority(priority);

        LocalDate date = LocalDate.parse(expenditureAttributes.getDate());

        expenditure.setDate(date);

        Currency currency = Currency.of(expenditureAttributes.getCurrency());

        Money money = Money.of(
            currency,
            expenditureAttributes.getValue()
        );

        expenditure.setMoney(money);

        Payee payee = new Payee(expenditureAttributes.getPayee());

        expenditure.setPayee(payee);

        expenditure.setRepeatInNextPeriod(expenditureAttributes.isRepeatInNextPeriod());

        expenditureRepository.save(expenditure);
    }

    @Override
    public void delete(ExpenditureDeleteCommand expenditureDeleteCommand) {

        Assert.notNull(expenditureDeleteCommand, "expenditureDeleteCommand must not be null");

        expenditureRepository.delete(
            expenditureDeleteCommand.cashFlowId(),
            expenditureDeleteCommand.expenditureId()
        );
    }

    @Override
    public void repeat(CashFlowRepeatCommand cashFlowRepeatCommand) {

        Assert.notNull(cashFlowRepeatCommand, "cashFlowRepeatCommand must not be null");

        expenditureRepository.findAllRepeated(cashFlowRepeatCommand.fromCashFlowId())
            .stream()
            .map(expenditure -> assignCashFlow(expenditure, cashFlowRepeatCommand.toCashFlowId()))
            .forEach(expenditureRepository::save);
    }

    private CashFlow getCashFlowByCashFlowId(Long cashFlowId) {

        return cashFlowRepository.findByCashFlowId(cashFlowId)
            .orElseThrow(() -> new NotFoundException("CashFlow", cashFlowId));
    }

    private Expenditure assignCashFlow(Expenditure expenditure, Long cashFlowId) {

        CashFlow cashFlow = getCashFlowByCashFlowId(cashFlowId);

        expenditure.setCashFlow(cashFlow);

        return expenditure;
    }

}
