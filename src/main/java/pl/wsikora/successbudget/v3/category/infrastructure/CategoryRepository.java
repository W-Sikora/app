package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;


@Repository
interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getByCategoryId(Long categoryId);

    @Query("select c from Category c where c.categoryId = ?1 and c.owner = ?2")
    Category getByCategoryIdAndUsername(Long categoryId, Username username);

    @Query("select count(c) > 0 from Category c where c.categoryId = ?1 and c.owner = ?2")
    boolean existsByCategoryIdAndUsername(Long categoryId, Username username);

    @Query("select c from Category c where c.owner = ?1")
    List<Category> getByUsername(Username username);

    @Query("select c from Category c where c.owner = ?1 and c.assignedTransactionType = ?2")
    List<Category> getByUsernameAndAssignedTransactionType(Username username, TransactionType transactionType);

    @Query("select count(c) from Category c where c.owner = ?1")
    int countAllByUsername(Username owner);

}
