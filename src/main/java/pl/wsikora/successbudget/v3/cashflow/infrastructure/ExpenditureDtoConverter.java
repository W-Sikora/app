package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.cashflow.domain.Expenditure;
import pl.wsikora.successbudget.v3.common.cashflow.ExpenditureDto;
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
import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;

@Service
class ExpenditureDtoConverter {

    private final CategoryDtoProvider categoryDtoProvider;

    private ExpenditureDtoConverter(CategoryDtoProvider categoryDtoProvider) {

        this.categoryDtoProvider = categoryDtoProvider;
    }

    ExpenditureDto toDto(Expenditure expenditure) {

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
