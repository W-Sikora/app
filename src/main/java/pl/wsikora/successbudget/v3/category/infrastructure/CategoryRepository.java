package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;
import java.util.Optional;


@Repository
interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("""
        select c
        from Category c
        where c.categoryId = ?1
        and c.owner.value = ?#{principal.username}
    """)
    Optional<Category> findCategoryByCategoryId(Long categoryId);

    @Query(
        value = """
            select c
            from Category c
            where c.owner.value = ?#{principal.username}
        """,
        countQuery = """
            select count(c)
            from Category c
            where c.owner.value = ?#{principal.username}
        """
    )
    Page<Category> findAll(Pageable pageable);


    @Modifying
    @Query("delete from Category c where c.categoryId = ?1 and c.owner.value = ?#{principal.username}")
    void deleteByCategoryId(Long categoryId);

    @Query("select c from Category c where c.categoryId = ?1 and c.owner.value = ?#{principal.username}")
    Category getByCategoryId(Long categoryId);

    @Query("select count(c) > 0 from Category c where c.categoryId = ?1 and c.owner.value = ?#{principal.username}")
    boolean existsByCategoryId(Long categoryId);

    @Query("select c from Category c where c.owner = ?1")
    List<Category> getByUsername(Username username);

    @Query("select c from Category c where c.owner = ?1 and c.assignedTransactionType = ?2")
    List<Category> getByUsernameAndAssignedTransactionType(Username username, TransactionType transactionType);

    @Query("select count(c) from Category c where c.owner = ?1")
    int countAllByUsername(Username owner);

}
