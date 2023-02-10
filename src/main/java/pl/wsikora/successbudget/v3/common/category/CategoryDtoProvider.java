package pl.wsikora.successbudget.v3.common.category;

import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;

import java.util.List;


public interface CategoryDtoProvider {

    CategoryDto provideCategoryDto(CategoryId categoryId);

    CategoryDto convert(CategoryId categoryId);

    List<CategoryDto> provideAllByAssignedTransactionType(TransactionType transactionType);

}
