package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.category.application.CategoryUserAccessChecker;
import pl.wsikora.successbudget.v3.common.type.CategoryId;


@Service
class CategoryUserAccessCheckerImpl implements CategoryUserAccessChecker {

    private final CategoryRepository categoryRepository;

    private CategoryUserAccessCheckerImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean hasAccess(CategoryId categoryId, Username username) {

        return categoryRepository.findCategoryByCategoryIdAndOwnedByUser(categoryId, username)
            .isPresent();
    }
}
