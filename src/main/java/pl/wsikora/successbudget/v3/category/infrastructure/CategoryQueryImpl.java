package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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

        return categoryRepository.findCategoryByCategoryId(categoryId)
            .map(this::toDto);
    }

    @Override
    public Page<CategoryDto> getAll(Pageable pageable, String keyword) {

        if (hasText(keyword)) {

            return categoryRepository.findAllByKeywordIgnoreCase(pageable, keyword.toLowerCase(Locale.ROOT))
                .map(this::toDto);
        }

        return categoryRepository.findAll(pageable)
            .map(this::toDto);
    }

    private CategoryDto toDto(Category category) {

        return new CategoryDto(
            category.getCategoryId(),
            category.getTitle().getValue(),
            category.getAssignedTransactionType().ordinal()
        );
    }

}
