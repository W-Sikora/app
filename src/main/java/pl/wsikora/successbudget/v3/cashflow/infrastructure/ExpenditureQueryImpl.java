package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.cashflow.application.ExpenditureDto;
import pl.wsikora.successbudget.v3.cashflow.application.ExpenditureQuery;

import java.util.Optional;


@Service
class ExpenditureQueryImpl implements ExpenditureQuery {

    private final ExpenditureRepository expenditureRepository;

    private ExpenditureQueryImpl(ExpenditureRepository expenditureRepository) {

        this.expenditureRepository = expenditureRepository;
    }

    @Override
    public Optional<ExpenditureDto> findByExpenditureId(Long expenditureId) {

        return Optional.empty();
    }
}
