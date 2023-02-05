package pl.wsikora.successbudget.v3.category.application;

import pl.wsikora.successbudget.v3.common.type.Username;


public interface CategoryCommand {

    void save(CategoryAttributes categoryAttributes, Username username);

    void delete(Long categoryId);
}
