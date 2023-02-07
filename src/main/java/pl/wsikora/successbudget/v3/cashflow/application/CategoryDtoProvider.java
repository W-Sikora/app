package pl.wsikora.successbudget.v3.cashflow.application;

import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.application.CategoryDto;


public interface CategoryDtoProvider {

    CategoryDto provideCategoryDto(CategoryId categoryId);

}
