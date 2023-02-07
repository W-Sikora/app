package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.application.CategoryDto;


@Service("cashflow-CategoryDtoProviderImpl")
public class CategoryDtoProviderImpl implements
    pl.wsikora.successbudget.v3.cashflow.application.CategoryDtoProvider {

    private final CategoryDtoProvider categoryTitleProvider;

    private CategoryDtoProviderImpl(CategoryDtoProvider categoryTitleProvider) {

        this.categoryTitleProvider = categoryTitleProvider;
    }

    @Override
    public CategoryDto provideCategoryDto(CategoryId categoryId) {

        return categoryTitleProvider.provideCategoryDto(categoryId);
    }

}
