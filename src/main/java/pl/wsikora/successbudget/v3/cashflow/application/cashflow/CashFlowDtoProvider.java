package pl.wsikora.successbudget.v3.cashflow.application.cashflow;

import java.time.YearMonth;


public interface CashFlowDtoProvider {

    CashFlowDto provideCashFlowDto(YearMonth period);

}
