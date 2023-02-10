package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.cashflow.application.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.cashflow.application.RevenueDto;
import pl.wsikora.successbudget.v3.cashflow.application.RevenueQuery;
import pl.wsikora.successbudget.v3.cashflow.domain.Revenue;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;

import java.util.Optional;


@Service
class RevenueQueryImpl implements RevenueQuery {

    private final RevenueRepository revenueRepository;
    private final CategoryDtoProvider categoryDtoProvider;

    private RevenueQueryImpl(RevenueRepository revenueRepository,
                             CategoryDtoProvider categoryDtoProvider) {

        this.revenueRepository = revenueRepository;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    @Override
    public Optional<RevenueDto> findByRevenueId(Long revenueId) {

        return revenueRepository.findByRevenueId(revenueId)
            .map(this::toDto);
    }

    private RevenueDto toDto(Revenue revenue) {

        CategoryId categoryId = revenue.getCategoryId();

        CategoryDto categoryDto = categoryDtoProvider.provideCategoryDto(categoryId);

        MoneyDto moneyDto = MoneyDtoFactory.convert(revenue.getMoney());

        return new RevenueDto(
            revenue.getRevenueId(),
            revenue.getCashFlow().getCashFlowId(),
            revenue.getTitle().getValue(),
            revenue.getDescription().getValue(),
            categoryDto,
            moneyDto,
            revenue.getPayer().getValue(),
            revenue.getDate().toString()
        );
    }
}
