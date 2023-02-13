package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowFilter;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureDto;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureQuery;
import pl.wsikora.successbudget.v3.cashflow.domain.Expenditure;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;
import pl.wsikora.successbudget.v3.common.type.payee.Payee;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDtoFactory;

import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.Constants.EXPENDITURE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.EXPENDITURE_EDIT_PATH;
import static pl.wsikora.successbudget.v3.common.util.DateFormatter.DATE_FORMATTER;
import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.convertToLowerCase;


@Service
class ExpenditureQueryImpl implements ExpenditureQuery {

    private final ExpenditureRepository expenditureRepository;
    private final CategoryDtoProvider categoryDtoProvider;

    private ExpenditureQueryImpl(
        ExpenditureRepository expenditureRepository,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.expenditureRepository = expenditureRepository;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    @Override
    public Optional<ExpenditureDto> findByExpenditureId(Long expenditureId) {

        Assert.notNull(expenditureId, "expenditureId must not be null");

        return expenditureRepository.findByExpenditureId(expenditureId)
            .map(this::toDto);
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
            .map(this::toDto);
    }

    private ExpenditureDto toDto(Expenditure expenditure) {

        Long expenditureId = expenditure.getExpenditureId();

        CategoryDto categoryDto = categoryDtoProvider.convert(expenditure.getCategoryId());

        MoneyDto moneyDto = MoneyDtoFactory.create(expenditure.getMoney());

        UrlDto urlDto = UrlDtoFactory.create(EXPENDITURE_EDIT_PATH,
            EXPENDITURE_DELETE_PATH, expenditureId);

        String payee = Optional.ofNullable(expenditure.getPayee())
            .map(Payee::getValue)
            .orElse(null);

        return new ExpenditureDto(
            expenditureId,
            expenditure.getPeriod().format(PERIOD_FORMATTER),
            expenditure.getTitle().getValue(),
            categoryDto,
            expenditure.getPriority().ordinal(),
            expenditure.getDate().asString(),
            moneyDto,
            payee,
            expenditure.isRepeatInNextPeriod(),
            urlDto
        );
    }

}
