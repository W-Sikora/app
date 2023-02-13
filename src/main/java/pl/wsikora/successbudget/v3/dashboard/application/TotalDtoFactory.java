package pl.wsikora.successbudget.v3.dashboard.application;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.budget.BudgetDto;
import pl.wsikora.successbudget.v3.common.budget.BudgetDtoProvider;
import pl.wsikora.successbudget.v3.common.cashflow.CashFlowDto;
import pl.wsikora.successbudget.v3.common.cashflow.CashFlowDtoProvider;

import java.time.YearMonth;


@Service
public class TotalDtoFactory {

    private final BudgetDtoProvider budgetDtoProvider;
    private final CashFlowDtoProvider cashFlowDtoProvider;

    private TotalDtoFactory(
        BudgetDtoProvider budgetDtoProvider,
        CashFlowDtoProvider cashFlowDtoProvider
    ) {

        this.budgetDtoProvider = budgetDtoProvider;
        this.cashFlowDtoProvider = cashFlowDtoProvider;
    }

    public TotalDto create(YearMonth period) {

        Assert.notNull(period, "period must not be null");

        BudgetDto budgetDto = budgetDtoProvider.provideBudgetDto(period);

        CashFlowDto cashFlowDto = cashFlowDtoProvider.provideCashFlowDto(period);

        return new TotalDto(
            budgetDto.getTotalPlannedExpenditures(),
            cashFlowDto.getTotalExpenditures(),
            budgetDto.getTotalPlannedRevenues(),
            cashFlowDto.getTotalRevenues(),
            budgetDto.getBalance(),
            cashFlowDto.getBalance()
        );
    }

}
