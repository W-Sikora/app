package pl.wsikora.successbudget.v3.category.application;

import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;


public interface CategoryQuery {

    CategoryDto getCategoryDto(Long categoryId);

    CategoryDto getCategoryDto(Long categoryId, Username username);

    List<CategoryDto> getAllCategoryDto(Username username);

    List<CategoryDto> getAllCategoryDto(Username username, TransactionType transactionType);

    boolean exists(Long categoryId, Username username);
}
