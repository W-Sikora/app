package pl.wsikora.successbudget.category.interfaces.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.category.application.query.CategoryQuery;
import pl.wsikora.successbudget.category.domain.Category;


@Service
class CategoryFormFactory {

    private final CategoryQuery categoryQuery;

    private CategoryFormFactory(CategoryQuery categoryQuery) {

        this.categoryQuery = categoryQuery;
    }

    CategoryForm createForm(Long id, Long creatorId) {

        return categoryQuery.findById(id)
                .map(this::convert)
                .orElseGet(() -> create(creatorId));
    }

    private CategoryForm convert(Category category) {

        CategoryForm form = new CategoryForm();

        form.setId(category.getValue());

        form.setCreatorId(category.getCreatorId());

        form.setName(category.getName());

        form.setParentCategoryId(category.getParentCategoryId());

        form.setColorId(category.getColorId());

        form.setIconId(category.getIconId());

        return form;
    }

    private CategoryForm create(Long creatorId) {

        CategoryForm form = new CategoryForm();

        form.setCreatorId(creatorId);

        return form;
    }
}
