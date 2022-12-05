package pl.wsikora.successbudget.category.application.query;


import pl.wsikora.successbudget.category.domain.Category;

import java.util.Optional;

public interface CategoryQuery {

    Optional<Category> findById(Long id);

    Category getById(Long id);
}
