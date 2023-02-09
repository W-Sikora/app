package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.category.application.CategoryAttributes;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.category.TransactionType;


@Service
class CategoryCommandImpl implements CategoryCommand {

    private final CategoryRepository categoryRepository;
    private final UsernameProvider usernameProvider;

    private CategoryCommandImpl(CategoryRepository categoryCrudRepository,
                                UsernameProvider usernameProvider) {

        this.categoryRepository = categoryCrudRepository;
        this.usernameProvider = usernameProvider;
    }

    @Override
    public void save(CategoryAttributes categoryAttributes) {

        Assert.notNull(categoryAttributes, "categoryAttributes must not be null");

        Category category = new Category();

        category.setCategoryId(categoryAttributes.getCategoryId());
        category.setTitle(new Title(categoryAttributes.getTitle()));
        category.setOwner(usernameProvider.getUsername());

        TransactionType transactionType = TransactionType.values()[categoryAttributes.getAssignedTransactionType()];
        category.setAssignedTransactionType(transactionType);

        categoryRepository.save(category);
    }

    @Override
    public void delete(Long categoryId) {

        Assert.notNull(categoryId, "categoryId must not be null");

        categoryRepository.delete(categoryId);
    }

}
