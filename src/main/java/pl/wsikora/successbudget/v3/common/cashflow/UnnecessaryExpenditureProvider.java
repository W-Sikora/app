package pl.wsikora.successbudget.v3.common.cashflow;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.YearMonth;


public interface UnnecessaryExpenditureProvider {

    Page<ExpenditureDto> findAllUnnecessaryExpenditures(Pageable pageable, YearMonth yearMonth);

}
