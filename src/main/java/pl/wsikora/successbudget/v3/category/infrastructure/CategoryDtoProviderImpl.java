package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import java.util.List;


@Service
public class CategoryDtoProviderImpl implements CategoryDtoProvider {

    private final CategoryRepository categoryRepository;
    private final MessageProvider messageProvider;

    private CategoryDtoProviderImpl(
        CategoryRepository categoryRepository,
        MessageProvider messageProvider
    ) {

        this.categoryRepository = categoryRepository;
        this.messageProvider = messageProvider;
    }

    @Override
    public CategoryDto provideCategoryDto(CategoryId categoryId) {

        Assert.notNull(categoryId, "categoryId must not be null");

        return categoryRepository.findByCategoryId(categoryId.getValue())
            .map(this::toDto)
            .orElseGet(() -> toDto(categoryId));
    }

    @Override
    public CategoryDto convert(CategoryId categoryId) {

        Assert.notNull(categoryId, "categoryId must not be null");

        return categoryRepository.findByCategoryId(categoryId.getValue())
            .map(this::toDto)
            .orElseGet(() -> toDto(categoryId));
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
            category.getTitle().getValue(),
            category.getColor()
        );
    }

    private CategoryDto toDto(CategoryId categoryId) {

        String message = messageProvider.getMessage("category.was.deleted");
        String deletedColor = "rgba(255, 0, 0, 0.5)";

        return new CategoryDto(
            categoryId.getValue(),
            message,
            deletedColor
        );
    }

}
