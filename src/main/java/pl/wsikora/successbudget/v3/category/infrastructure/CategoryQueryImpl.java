package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDtoFactory;

import java.util.Locale;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;
import static pl.wsikora.successbudget.v3.common.util.Constants.CATEGORY_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.CATEGORY_EDIT_PATH;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.convertToLowerCase;


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

        return categoryRepository.findAll(pageable, convertToLowerCase(keyword))
            .map(this::toDto);
    }

    private CategoryDto toDto(Category category) {

        Long categoryId = category.getCategoryId();

        UrlDto urlDto = UrlDtoFactory.create(CATEGORY_EDIT_PATH, CATEGORY_DELETE_PATH, categoryId);

        return new CategoryDto(
            categoryId,
            category.getTitle().getValue(),
            category.getTransactionType().ordinal(),
            urlDto
        );
    }

}
