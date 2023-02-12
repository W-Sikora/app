package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueAttributes;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueCommand;
import pl.wsikora.successbudget.v3.cashflow.domain.CashFlow;
import pl.wsikora.successbudget.v3.cashflow.domain.Revenue;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.payer.Payer;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;

import java.time.LocalDate;


@Service
class RevenueCommandImpl implements RevenueCommand {

    private final UsernameProvider usernameProvider;
    private final RevenueRepository revenueRepository;
    private final CashFlowRepository cashFlowRepository;

    private RevenueCommandImpl(UsernameProvider usernameProvider,
                               RevenueRepository revenueRepository,
                               CashFlowRepository cashFlowRepository) {

        this.usernameProvider = usernameProvider;
        this.revenueRepository = revenueRepository;
        this.cashFlowRepository = cashFlowRepository;
    }

    @Override
    public void save(RevenueAttributes revenueAttributes) {

        Assert.notNull(revenueAttributes, "revenueAttributes must not be null");

        Revenue revenue = new Revenue();

        revenue.setRevenueId(revenueAttributes.getRevenueId());

        CashFlow cashFlow = getCashFlowByCashFlowId(revenueAttributes.getCashFlowId());

        revenue.setCashFlow(cashFlow);

        revenue.setOwner(usernameProvider.getUsername());

        CategoryId categoryId = new CategoryId(revenueAttributes.getCategoryId());

        revenue.setCategoryId(categoryId);

        LocalDate date = LocalDate.parse(revenueAttributes.getDate());

        revenue.setDate(date);

        Currency currency = Currency.of(revenueAttributes.getCurrency());

        Money money = Money.of(
            currency,
            revenueAttributes.getValue()
        );

        revenue.setMoney(money);

        Payer payer = new Payer(revenueAttributes.getPayer());

        revenue.setPayer(payer);

        revenue.setRepeatInNextPeriod(revenueAttributes.isRepeatInNextPeriod());

        revenueRepository.save(revenue);
    }

    @Override
    public void delete(Long cashFlowId, Long revenueId) {

        Assert.notNull(cashFlowId, "cashFlowId must not be null");
        Assert.notNull(revenueId, "revenueId must not be null");

        if (!cashFlowRepository.hasCashFlow(cashFlowId)) {

            return;
        }

        revenueRepository.delete(revenueId);
    }

    @Override
    public void repeat(Long fromCashFlowId, Long toCashFlowId) {

        Assert.notNull(fromCashFlowId, "fromCashFlowId must not be null");
        Assert.notNull(toCashFlowId, "toCashFlowId must not be null");

        revenueRepository.findAllRepeated(fromCashFlowId)
            .stream()
            .map(this::assignCashFlow)
            .forEach(revenueRepository::save);
    }

    private CashFlow getCashFlowByCashFlowId(Long cashFlowId) {

        return cashFlowRepository.findByCashFlowId(cashFlowId)
            .orElseThrow(() -> new NotFoundException("CashFlow", cashFlowId));
    }

    private Revenue assignCashFlow(Revenue revenue) {

        CashFlow cashFlow = getCashFlowByCashFlowId(revenue.getCashFlow().getCashFlowId());

        revenue.setCashFlow(cashFlow);

        return revenue;
    }

}
