package pl.wsikora.successbudget.category.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractCommand;
import pl.wsikora.successbudget.category.application.command.CategoryCommand;
import pl.wsikora.successbudget.category.domain.Category;


@Service
class HibernateCategoryCommand extends AbstractCommand<Category> implements CategoryCommand {

    @Override
    protected Class<Category> entityClass() {

        return Category.class;
    }
}
