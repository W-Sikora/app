package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.cashflow.application.RevenueDto;
import pl.wsikora.successbudget.v3.cashflow.application.RevenueQuery;


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

        return RevenueForm.builder()
            .revenueId(revenueDto.getRevenueId())
            .cashFlowId(revenueDto.getCashFlowId())
            .title(revenueDto.getTitle())
            .description(revenueDto.getDescription())
            .categoryId(revenueDto.getCategoryDto().getCategoryId())
            .currencyId(revenueDto.getMoneyDto().getCurrencyId())
            .value(revenueDto.getMoneyDto().getValue())
            .payer(revenueDto.getPayer())
            .date(revenueDto.getDate())
            .build();
    }
}
