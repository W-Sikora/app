package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.cashflow.application.RevenueDto;
import pl.wsikora.successbudget.v3.cashflow.application.RevenueQuery;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;


@Service
class RevenueFormFactory {

    private final RevenueQuery revenueQuery;

    private RevenueFormFactory(RevenueQuery revenueQuery) {

        this.revenueQuery = revenueQuery;
    }

    RevenueForm getRevenueForm(Long revenueId) {

        return revenueQuery.findByRevenueId(revenueId)
            .map(this::toForm)
            .orElseGet(RevenueForm::new);
    }

    private RevenueForm toForm(RevenueDto revenueDto) {

        MoneyDto moneyDto = revenueDto.getMoneyDto();

        Money money = moneyDto.getMoney();

        return RevenueForm.builder()
            .revenueId(revenueDto.getRevenueId())
            .cashFlowId(revenueDto.getCashFlowId())
            .title(revenueDto.getTitle())
            .description(revenueDto.getDescription())
            .categoryId(revenueDto.getCategoryDto().getCategoryId())
            .currencyId(money.getCurrency().ordinal())
            .value(money.getValue())
            .payer(revenueDto.getPayer())
            .date(revenueDto.getDate())
            .build();
    }

}
