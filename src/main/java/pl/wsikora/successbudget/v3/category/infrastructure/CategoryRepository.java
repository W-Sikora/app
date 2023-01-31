package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;
import java.util.Optional;


@Repository
interface CategoryRepository extends JpaRepository<Category, CategoryId> {

    Optional<Category> findCategoryByCategoryIdAndOwnedByUser(CategoryId categoryId, Username username);

    List<Category> getCategoryByOwnedByUser(Username username);
}
