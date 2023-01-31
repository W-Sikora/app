package pl.wsikora.successbudget.v3.category.application;

import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;


public interface CategoryQuery {

    CategoryDto getCategoryDto(CategoryId categoryId, Username username);

    List<CategoryDto> getAllCategoryDto(Username username);
}
