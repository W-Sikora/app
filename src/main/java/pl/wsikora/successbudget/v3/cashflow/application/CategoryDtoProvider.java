package pl.wsikora.successbudget.v3.cashflow.application;

import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;


public interface CategoryDtoProvider {

    CategoryDto provideCategoryDto(CategoryId categoryId);

}
