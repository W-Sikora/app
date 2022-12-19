package pl.wsikora.successbudget.category.application.query;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.currency.domain.Currency;

@Service
public class CategoryQueryService {

    private final CategoryQuery categoryQuery;

    public CategoryQueryService(CategoryQuery categoryQuery) {

        this.categoryQuery = categoryQuery;
    }

    private CategoryDto convert(Currency currency) {

        return new CategoryDto(
                currency.getValue(),
                currency.getName(),
                currency.getCode(),
                currency.getSymbol()
        );
    }
}
