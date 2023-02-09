package pl.wsikora.successbudget.v3.common.category;

import java.util.List;


public interface CategoryDtoProvider {

    CategoryDto provideCategoryDto(CategoryId categoryId);

    CategoryDto convert(CategoryId categoryId);

    List<CategoryDto> provideAllByAssignedTransactionType(TransactionType transactionType);

}
