package pl.wsikora.successbudget.v3.common.cashflow;

import java.time.YearMonth;


public interface CashFlowDtoProvider {

    CashFlowDto provideCashFlowDto(YearMonth period);



}
