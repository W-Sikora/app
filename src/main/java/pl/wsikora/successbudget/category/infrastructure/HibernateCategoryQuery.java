package pl.wsikora.successbudget.category.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractQuery;
import pl.wsikora.successbudget.category.application.query.CategoryQuery;
import pl.wsikora.successbudget.category.domain.Category;

@Service
class HibernateCategoryQuery extends AbstractQuery<Category> implements CategoryQuery {

    @Override
    protected Class<Category> entityClass() {

        return Category.class;
    }
}
