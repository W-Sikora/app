package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryAttributes;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.*;
import pl.wsikora.successbudget.v3.user.domain.User;


@Service
class CategoryCommandImpl implements CategoryCommand {

    private final UserCrudRepository userCrudRepository;
    private final CategoryRepository categoryRepository;

    private CategoryCommandImpl(UserCrudRepository userCrudRepository,
                                CategoryRepository categoryCrudRepository) {

        this.userCrudRepository = userCrudRepository;
        this.categoryRepository = categoryCrudRepository;
    }

    @Override
    public void save(CategoryAttributes categoryAttributes, Username username) {

        User user = userCrudRepository.findById(username)
            .orElseThrow(() -> new IllegalArgumentException("No user found for username: " + username));

        Category category = Category.builder()
            .categoryId(new CategoryId(categoryAttributes.getCategoryId()))
            .title(new Title(categoryAttributes.getTitle()))
            .description(new Description(categoryAttributes.getDescription()))
            .assignedTransactionType(TransactionType.valueOf(categoryAttributes.getAssignedTransactionType()))
            .ownedByUser(user)
            .build();

        categoryRepository.save(category);
    }

    @Override
    public void delete(CategoryId categoryId) {

        categoryRepository.deleteById(categoryId);
    }
}
