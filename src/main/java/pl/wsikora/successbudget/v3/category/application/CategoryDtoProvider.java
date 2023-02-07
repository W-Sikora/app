package pl.wsikora.successbudget.v3.category.application;

import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.application.CategoryDto;


public interface CategoryDtoProvider {

    CategoryDto provideCategoryDto(CategoryId categoryId);

}
