package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;


@Service
class CategoryFormFactory {

    private final CategoryQuery categoryQuery;

    private CategoryFormFactory(CategoryQuery categoryQuery) {

        this.categoryQuery = categoryQuery;
    }

    CategoryForm getCategoryForm(Long categoryId) {

        return toForm(categoryQuery.getCategoryDto(categoryId));
    }

    private static CategoryForm toForm(CategoryDto categoryDto) {

        CategoryForm categoryForm = new CategoryForm();
        categoryForm.setCategoryId(categoryDto.getCategoryId());
        categoryForm.setTitle(categoryDto.getTitle());
        categoryForm.setDescription(categoryDto.getDescription());
        categoryForm.setAssignedTransactionType(categoryDto.getAssignedTransactionType());

        return categoryForm;
    }
}
