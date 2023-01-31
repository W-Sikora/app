package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.common.type.CategoryId;


@Service
class CategoryFormFactory {

    private final CategoryQuery categoryQuery;

    private CategoryFormFactory(CategoryQuery categoryQuery) {

        this.categoryQuery = categoryQuery;
    }

    CategoryForm getCategoryForm(CategoryId categoryId, Username username) {

        return convert(categoryQuery.getCategoryDto(categoryId, username));
    }


    private CategoryForm convert(CategoryDto categoryDto) {

        return CategoryForm.builder()
            .categoryId(categoryDto.getCategoryId())
            .title(categoryDto.getTitle())
            .description(categoryDto.getDescription())
            .assignedTransactionType(categoryDto.getAssignedTransactionType())
            .build();
    }
}
