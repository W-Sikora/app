package pl.wsikora.successbudget.v3.category.application;

import org.springframework.data.domain.Pageable;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;
import java.util.Optional;


public interface CategoryQuery {

    Optional<CategoryDto> findByCategoryId(Long categoryId);

    CategoryDto getCategoryDto(Long categoryId);


    List<CategoryDto> getAllCategoryDto(Pageable pageable);

    List<CategoryDto> getAllCategoryDto(Username username, TransactionType transactionType);

    boolean exists(Long categoryId);
}
