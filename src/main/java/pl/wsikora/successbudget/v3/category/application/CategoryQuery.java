package pl.wsikora.successbudget.v3.category.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.Optional;


public interface CategoryQuery {

    Optional<CategoryDto> findByCategoryId(Long categoryId);

    Page<CategoryDto> findAll(Pageable pageable, @Nullable String keyword);

}
