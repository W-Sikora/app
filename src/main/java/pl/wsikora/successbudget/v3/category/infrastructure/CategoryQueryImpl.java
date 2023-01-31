package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;


@Service
class CategoryQueryImpl implements CategoryQuery {

    private final CategoryRepository categoryRepository;

    private CategoryQueryImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto getCategoryDto(CategoryId categoryId, Username username) {

        return categoryRepository.findCategoryByCategoryIdAndOwnedByUser(categoryId, username)
            .map(this::toDto)
            .orElseThrow(() -> new IllegalArgumentException("No category found for categoryId: " + categoryId.getValue()));
    }

    @Override
    public List<CategoryDto> getAllCategoryDto(Username username) {

        return categoryRepository.getCategoryByOwnedByUser(username)
            .stream()
            .map(this::toDto)
            .toList();
    }

    private CategoryDto toDto(Category category) {

        return new CategoryDto(
            category.getCategoryId().getValue(),
            category.getTitle().getValue(),
            category.getDescription().getValue(),
            category.getAssignedTransactionType().toString()
        );
    }
}
