package pl.wsikora.successbudget.category.application.command;

import pl.wsikora.successbudget.category.domain.Category;


public interface CategoryCommand {

    void save(Category category);

    void delete(long id);
}
