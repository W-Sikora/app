package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.category.domain.Category;

import java.util.Locale;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;


@Service
class CategoryQueryImpl implements CategoryQuery {

    private final CategoryRepository categoryRepository;

    private CategoryQueryImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<CategoryDto> findByCategoryId(Long categoryId) {

        Assert.notNull(categoryId, "categoryId must not be null");

        return categoryRepository.findByCategoryId(categoryId)
            .map(this::toDto);
    }

    @Override
    public Page<CategoryDto> findAll(Pageable pageable, @Nullable String keyword) {

        Assert.notNull(pageable, "pageable must not be null");

        if (hasText(keyword)) {

            return categoryRepository.findAllByKeyword(pageable, keyword.toLowerCase(Locale.ROOT))
                .map(this::toDto);
        }

        return categoryRepository.findAll(pageable)
            .map(this::toDto);
    }

    private CategoryDto toDto(Category category) {

        return new CategoryDto(
            category.getCategoryId(),
            category.getTitle().getValue(),
            category.getTransactionType().getValue()
        );
    }

}
