package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureAttributes;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureCommand;
import pl.wsikora.successbudget.v3.cashflow.domain.Expenditure;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.date.Date;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.payee.Payee;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.repeat.RepeatCommand;
import pl.wsikora.successbudget.v3.common.type.title.Title;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;

import java.time.YearMonth;

import static org.springframework.util.StringUtils.hasText;


@Service
class ExpenditureCommandImpl implements ExpenditureCommand {

    private final UsernameProvider usernameProvider;
    private final ExpenditureRepository expenditureRepository;

    private ExpenditureCommandImpl(
        UsernameProvider usernameProvider,
        ExpenditureRepository expenditureRepository
    ) {

        this.usernameProvider = usernameProvider;
        this.expenditureRepository = expenditureRepository;
    }

    @Override
    public void save(ExpenditureAttributes expenditureAttributes) {

        Assert.notNull(expenditureAttributes, "expenditureAttributes must not be null");

        Expenditure expenditure = new Expenditure();

        expenditure.setExpenditureId(expenditureAttributes.getExpenditureId());

        expenditure.setPeriod(expenditureAttributes.getPeriod());

        expenditure.setOwner(usernameProvider.getUsername());

        expenditure.setTitle(Title.of(expenditureAttributes.getTitle()));

        CategoryId categoryId = CategoryId.of(expenditureAttributes.getCategoryId());

        expenditure.setCategoryId(categoryId);

        Priority priority = Priority.of(expenditureAttributes.getPriority());

        expenditure.setPriority(priority);

        expenditure.setDate(Date.of(expenditureAttributes.getDate()));

        Currency currency = Currency.of(expenditureAttributes.getCurrency());

        expenditure.setMoney(Money.of(currency, expenditureAttributes.getValue()));

        String payee = expenditureAttributes.getPayee();

        if (hasText(payee)) {

            expenditure.setPayee(Payee.of(payee));
        }

        expenditure.setRepeatInNextPeriod(expenditureAttributes.isRepeatInNextPeriod());

        expenditureRepository.save(expenditure);
    }

    @Override
    public void delete(Long expenditureId) {

        Assert.notNull(expenditureId, "expenditureId must not be null");

        expenditureRepository.delete(expenditureId);
    }

    @Override
    public void repeat(RepeatCommand repeatCommand) {

        Assert.notNull(repeatCommand, "repeatCommand must not be null");

        expenditureRepository.findRepeatable(repeatCommand.fromPeriod())
            .stream()
            .map(expenditure -> assignCashFlow(expenditure, repeatCommand.toPeriod()))
            .forEach(expenditureRepository::save);
    }

    private Expenditure assignCashFlow(Expenditure expenditure, YearMonth toPeriod) {

        expenditure.setExpenditureId(null);

        expenditure.setPeriod(toPeriod);

        return expenditure;
    }

}
