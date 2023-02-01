package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;


@Service
class CategoryQueryImpl implements CategoryQuery {

    private final CategoryRepository categoryRepository;

    private CategoryQueryImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto getCategoryDto(Long categoryId) {

        return toDto(categoryRepository.getByCategoryId(categoryId));
    }

    @Override
    public CategoryDto getCategoryDto(Long categoryId, Username username) {

        return toDto(categoryRepository.getByCategoryIdAndUsername(categoryId, username));
    }

    @Override
    public List<CategoryDto> getAllCategoryDto(Username username) {

        return categoryRepository.getByUsername(username)
            .stream()
            .map(this::toDto)
            .toList();
    }

    @Override
    public List<CategoryDto> getAllCategoryDto(Username username, TransactionType transactionType) {

        return categoryRepository.getByUsernameAndAssignedTransactionType(username, transactionType)
            .stream()
            .map(this::toDto)
            .toList();
    }

    @Override
    public boolean exists(Long categoryId, Username username) {

        return categoryRepository.existsByCategoryIdAndUsername(categoryId, username);
    }

    private CategoryDto toDto(Category category) {

        return new CategoryDto(
            category.getCategoryId(),
            category.getTitle().getValue(),
            category.getDescription().getValue(),
            category.getAssignedTransactionType().ordinal()
        );
    }
}
