package pl.wsikora.successbudget.category.application.command;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.category.domain.Category;

import static java.util.Objects.isNull;


@Service
public class CategoryCommandService {

    private final CategoryCommand categoryCommand;

    private CategoryCommandService(CategoryCommand categoryCommand) {

        this.categoryCommand = categoryCommand;
    }

    public void save(CategoryFormAttribute attribute) {

        Category category = convert(attribute);

        categoryCommand.save(category);
    }

    public void delete(long id) {

        categoryCommand.delete(id);
    }

    private Category convert(CategoryFormAttribute attribute) {

        Category category = new Category();

        category.setId(attribute.getId());

        category.setCreatorId(attribute.getCreatorId());

        category.setName(attribute.getName());

        Long parentCategoryId = attribute.getParentCategoryId();

        category.setParentCategoryId(parentCategoryId);

        if (isNull(parentCategoryId)) {

            category.setColorId(attribute.getColorId());

            category.setIconId(attribute.getIconId());
        }

        return category;
    }
}
