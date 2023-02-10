package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;

import java.util.List;


@Service
public class CategoryDtoProviderImpl implements CategoryDtoProvider {

    private final CategoryRepository categoryRepository;

    private CategoryDtoProviderImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto provideCategoryDto(CategoryId categoryId) {

        Assert.notNull(categoryId, "categoryId must not be null");

        return categoryRepository.findByCategoryId(categoryId.getValue())
            .map(this::toDto)
            .orElseThrow(() -> new NotFoundException("CategoryDto", categoryId.getValue()));
    }

    @Override
    public CategoryDto convert(CategoryId categoryId) {

        Assert.notNull(categoryId, "categoryId must not be null");

        return categoryRepository.findByCategoryId(categoryId.getValue())
            .map(this::toDto)
            .orElseThrow(() -> new NotFoundException("CategoryDto", categoryId.getValue()));
    }

    @Override
    public List<CategoryDto> provideAllByAssignedTransactionType(TransactionType transactionType) {

        Assert.notNull(transactionType, "transactionType must not be null");

        return categoryRepository.findAllByTransactionType(transactionType)
            .stream()
            .map(this::toDto)
            .toList();
    }

    private CategoryDto toDto(Category category) {

        return new CategoryDto(
            category.getCategoryId(),
            category.getTitle().getValue()
        );
    }

}
