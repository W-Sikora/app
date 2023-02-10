package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;

import java.util.Optional;


@Service
class CategoryFormFactory {

    private final CategoryQuery categoryQuery;

    private CategoryFormFactory(CategoryQuery categoryQuery) {

        this.categoryQuery = categoryQuery;
    }

    CategoryForm getCategoryForm(@Nullable Long categoryId) {

        return Optional.ofNullable(categoryId)
            .flatMap(categoryQuery::findByCategoryId)
            .map(this::toForm)
            .orElseGet(CategoryForm::new);
    }

    private CategoryForm toForm(CategoryDto categoryDto) {

        return CategoryForm.builder()
            .categoryId(categoryDto.getCategoryId())
            .title(categoryDto.getTitle())
            .transactionType(categoryDto.getTransactionType())
            .build();
    }

}
