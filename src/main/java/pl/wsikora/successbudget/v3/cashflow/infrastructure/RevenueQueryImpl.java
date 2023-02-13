package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowFilter;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueDto;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueQuery;
import pl.wsikora.successbudget.v3.cashflow.domain.Revenue;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDtoFactory;

import java.util.Optional;

import static pl.wsikora.successbudget.v3.common.util.Constants.REVENUE_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.REVENUE_EDIT_PATH;
import static pl.wsikora.successbudget.v3.common.util.DateFormatter.DATE_FORMATTER;
import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.convertToLowerCase;


@Service
class RevenueQueryImpl implements RevenueQuery {

    private final RevenueRepository revenueRepository;
    private final CategoryDtoProvider categoryDtoProvider;

    private RevenueQueryImpl(
        RevenueRepository revenueRepository,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.revenueRepository = revenueRepository;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    @Override
    public Optional<RevenueDto> findByRevenueId(Long revenueId) {

        Assert.notNull(revenueId, "revenueId must not be null");

        return revenueRepository.findByRevenueId(revenueId)
            .map(this::toDto);
    }

    @Override
    public Page<RevenueDto> findAll(CashFlowFilter cashFlowFilter) {

        Assert.notNull(cashFlowFilter, "cashFlowFilter must not be null");

        return revenueRepository.findAll(
                cashFlowFilter.pageable(),
                cashFlowFilter.period(),
                convertToLowerCase(cashFlowFilter.expenditureKeyword()),
                cashFlowFilter.categoryId(),
                cashFlowFilter.fromDate(),
                cashFlowFilter.toDate()
            )
            .map(this::toDto);
    }

    private RevenueDto toDto(Revenue revenue) {

        Long revenueId = revenue.getRevenueId();

        CategoryDto categoryDto = categoryDtoProvider.convert(revenue.getCategoryId());

        MoneyDto moneyDto = MoneyDtoFactory.create(revenue.getMoney());

        UrlDto urlDto = UrlDtoFactory.create(REVENUE_EDIT_PATH,
            REVENUE_DELETE_PATH, revenueId);

        return new RevenueDto(
            revenueId,
            revenue.getPeriod().format(PERIOD_FORMATTER),
            revenue.getTitle().getValue(),
            categoryDto,
            revenue.getDate().format(DATE_FORMATTER),
            moneyDto,
            revenue.getPayer().getValue(),
            revenue.isRepeatInNextPeriod(),
            urlDto
        );
    }

}
