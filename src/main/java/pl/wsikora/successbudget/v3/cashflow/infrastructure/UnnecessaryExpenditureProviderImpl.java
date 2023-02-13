package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.cashflow.ExpenditureDto;
import pl.wsikora.successbudget.v3.common.cashflow.UnnecessaryExpenditureProvider;

import java.time.YearMonth;


@Service
class UnnecessaryExpenditureProviderImpl implements UnnecessaryExpenditureProvider {

    private final ExpenditureRepository expenditureRepository;
    private final ExpenditureDtoConverter expenditureDtoConverter;

    private UnnecessaryExpenditureProviderImpl(
        ExpenditureRepository expenditureRepository,
        ExpenditureDtoConverter expenditureDtoConverter
    ) {

        this.expenditureRepository = expenditureRepository;
        this.expenditureDtoConverter = expenditureDtoConverter;
    }

    @Override
    public Page<ExpenditureDto> findAllUnnecessaryExpenditures(Pageable pageable, YearMonth yearMonth) {

        return expenditureRepository.findAllUnnecessary(pageable, yearMonth)
            .map(expenditureDtoConverter::toDto);
    }

}
