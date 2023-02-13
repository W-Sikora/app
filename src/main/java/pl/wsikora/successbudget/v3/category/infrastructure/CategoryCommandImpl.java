package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.category.application.CategoryAttributes;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.title.Title;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;


@Service
class CategoryCommandImpl implements CategoryCommand {

    private final UsernameProvider usernameProvider;
    private final CategoryRepository categoryRepository;

    private CategoryCommandImpl(
        UsernameProvider usernameProvider,
        CategoryRepository categoryCrudRepository
    ) {

        this.usernameProvider = usernameProvider;
        this.categoryRepository = categoryCrudRepository;
    }

    @Override
    public void save(CategoryAttributes categoryAttributes) {

        Assert.notNull(categoryAttributes, "categoryAttributes must not be null");

        Category category = new Category();

        category.setCategoryId(categoryAttributes.getCategoryId());

        category.setTitle(Title.of(categoryAttributes.getTitle()));

        category.setOwner(usernameProvider.getUsername());

        category.setTransactionType(TransactionType.of(categoryAttributes.getTransactionType()));

        categoryRepository.save(category);
    }

    @Override
    public void delete(Long categoryId) {

        Assert.notNull(categoryId, "categoryId must not be null");

        categoryRepository.delete(categoryId);
    }

}
