package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueAttributes;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueCommand;
import pl.wsikora.successbudget.v3.cashflow.domain.Revenue;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.payer.Payer;
import pl.wsikora.successbudget.v3.common.type.repeat.RepeatCommand;
import pl.wsikora.successbudget.v3.common.type.title.Title;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;

import java.time.LocalDate;
import java.time.YearMonth;


@Service
class RevenueCommandImpl implements RevenueCommand {

    private final UsernameProvider usernameProvider;
    private final RevenueRepository revenueRepository;

    private RevenueCommandImpl(
        UsernameProvider usernameProvider,
        RevenueRepository revenueRepository
    ) {

        this.usernameProvider = usernameProvider;
        this.revenueRepository = revenueRepository;
    }

    @Override
    public void save(RevenueAttributes revenueAttributes) {

        Assert.notNull(revenueAttributes, "revenueAttributes must not be null");

        Revenue revenue = new Revenue();

        revenue.setRevenueId(revenueAttributes.getRevenueId());

        revenue.setPeriod(revenueAttributes.getPeriod());

        revenue.setOwner(usernameProvider.getUsername());

        revenue.setTitle(Title.of(revenueAttributes.getTitle()));

        revenue.setCategoryId(CategoryId.of(revenueAttributes.getCategoryId()));

        revenue.setDate(revenueAttributes.getDate());

        Currency currency = Currency.of(revenueAttributes.getCurrency());

        Money money = Money.of(currency, revenueAttributes.getValue());

        revenue.setMoney(money);

        revenue.setPayer(Payer.of(revenueAttributes.getPayer()));

        revenue.setRepeatInNextPeriod(revenueAttributes.isRepeatInNextPeriod());

        revenueRepository.save(revenue);
    }

    @Override
    public void delete(Long revenueId) {

        Assert.notNull(revenueId, "revenueId must not be null");

        revenueRepository.delete(revenueId);
    }

    @Override
    public void repeat(RepeatCommand repeatCommand) {

        Assert.notNull(repeatCommand, "repeatCommand must not be null");

        revenueRepository.findRepeatable(repeatCommand.fromPeriod())
            .stream()
            .map(revenue -> assignCashFlow(revenue, repeatCommand.toPeriod()))
            .forEach(revenueRepository::save);
    }

    private Revenue assignCashFlow(Revenue revenue, YearMonth toPeriod) {

        revenue.setRevenueId(null);

        revenue.setPeriod(toPeriod);

        return revenue;
    }

}
