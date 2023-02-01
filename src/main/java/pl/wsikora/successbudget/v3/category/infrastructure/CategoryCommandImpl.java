package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.category.application.CategoryAttributes;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.Description;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.type.Username;


@Service
class CategoryCommandImpl implements CategoryCommand {

    private final CategoryRepository categoryRepository;

    private CategoryCommandImpl(CategoryRepository categoryCrudRepository) {

        this.categoryRepository = categoryCrudRepository;
    }

    @Override
    public void save(CategoryAttributes categoryAttributes, Username username) {

        Category category = new Category();

        category.setCategoryId(categoryAttributes.getCategoryId());
        category.setTitle(new Title(categoryAttributes.getTitle()));
        category.setDescription(new Description(categoryAttributes.getDescription()));
        category.setOwner(username);

        TransactionType transactionType = TransactionType.values()[categoryAttributes.getAssignedTransactionType()];
        category.setAssignedTransactionType(transactionType);

        categoryRepository.save(category);
    }

    @Override
    public void delete(Long categoryId, Username username) {

        if (categoryRepository.existsByCategoryIdAndUsername(categoryId, username)) {

            categoryRepository.deleteById(categoryId);
        }
    }
}
