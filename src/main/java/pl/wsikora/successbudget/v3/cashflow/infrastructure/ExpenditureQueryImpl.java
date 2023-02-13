package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowFilter;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureQuery;
import pl.wsikora.successbudget.v3.common.cashflow.ExpenditureDto;

import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.StringUtils.convertToLowerCase;


@Service
class ExpenditureQueryImpl implements ExpenditureQuery {

    private final ExpenditureRepository expenditureRepository;
    private final ExpenditureDtoConverter expenditureDtoConverter;

    private ExpenditureQueryImpl(
        ExpenditureRepository expenditureRepository,
        ExpenditureDtoConverter expenditureDtoConverter
    ) {

        this.expenditureRepository = expenditureRepository;
        this.expenditureDtoConverter = expenditureDtoConverter;
    }

    @Override
    public Optional<ExpenditureDto> findByExpenditureId(Long expenditureId) {

        Assert.notNull(expenditureId, "expenditureId must not be null");

        return expenditureRepository.findByExpenditureId(expenditureId)
            .map(expenditureDtoConverter::toDto);
    }

    @Override
    public Page<ExpenditureDto> findAll(CashFlowFilter cashFlowFilter) {

        Assert.notNull(cashFlowFilter, "cashFlowFilter must not be null");

        return expenditureRepository.findAll(
                cashFlowFilter.pageable(),
                cashFlowFilter.period(),
                convertToLowerCase(cashFlowFilter.expenditureKeyword()),
                cashFlowFilter.categoryId(),
                cashFlowFilter.fromDate(),
                cashFlowFilter.toDate()
            )
            .map(expenditureDtoConverter::toDto);
    }

}
