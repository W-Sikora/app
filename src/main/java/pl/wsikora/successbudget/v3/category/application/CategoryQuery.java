package pl.wsikora.successbudget.v3.category.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CategoryQuery {

    Optional<CategoryDto> findByCategoryId(Long categoryId);

    Page<CategoryDto> getAll(Pageable pageable, String keyword);

}
