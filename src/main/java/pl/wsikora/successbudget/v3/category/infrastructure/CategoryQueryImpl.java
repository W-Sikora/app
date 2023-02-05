package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;
import java.util.Optional;


@Service
class CategoryQueryImpl implements CategoryQuery {

    private final CategoryRepository categoryRepository;

    private CategoryQueryImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<CategoryDto> findByCategoryId(Long categoryId) {

        return categoryRepository.findCategoryByCategoryId(categoryId)
            .map(this::toDto);
    }

    @Override
    public CategoryDto getCategoryDto(Long categoryId) {

        return toDto(categoryRepository.getByCategoryId(categoryId));
    }

    @Override
    public List<CategoryDto> getAllCategoryDto(Pageable pageable) {

        return categoryRepository.findAll(pageable)
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
    public boolean exists(Long categoryId) {

        return categoryRepository.existsByCategoryId(categoryId);
    }

    private CategoryDto toDto(Category category) {

        return new CategoryDto(
            category.getCategoryId(),
            category.getTitle().getValue(),
            category.getAssignedTransactionType().ordinal()
        );
    }
}
