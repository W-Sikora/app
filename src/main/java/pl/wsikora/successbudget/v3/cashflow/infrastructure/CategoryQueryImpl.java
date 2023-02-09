//package pl.wsikora.successbudget.v3.cashflow.infrastructure;
//
//import org.springframework.stereotype.Service;
//import pl.wsikora.successbudget.v3.category.application.CategoryDto;
//import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
//import pl.wsikora.successbudget.v3.common.category.TransactionType;
//import pl.wsikora.successbudget.v3.common.username.Username;
//
//import java.util.List;
//
//
//@Service
//class CategoryQueryImpl implements pl.wsikora.successbudget.v3.cashflow.application.CategoryQuery {
//
//    private final CategoryQuery categoryQuery;
//
//    public CategoryQueryImpl(CategoryQuery categoryQuery) {
//
//        this.categoryQuery = categoryQuery;
//    }
//
//    @Override
//    public List<CategoryDto> getAllCategoryDto(Username username, TransactionType transactionType) {
//
//        return categoryQuery.getAllCategoryDto(username, transactionType);
//    }
//}
