package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.application.CategoryDto;


@Service
public class CategoryDtoProviderImpl implements CategoryDtoProvider {

    private final CategoryRepository categoryRepository;

    private CategoryDtoProviderImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto provideCategoryDto(CategoryId categoryId) {

        return categoryRepository.findCategoryByCategoryId(categoryId.getValue())
            .map(this::toDto)
            .orElseThrow(() -> new IllegalArgumentException("No CategoryDto found for categoryId: " + categoryId.getValue()));
    }

    private CategoryDto toDto(Category category) {

        return new CategoryDto(
            category.getCategoryId(),
            category.getTitle().getValue()
        );
    }
}
