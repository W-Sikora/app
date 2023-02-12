package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;

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
    Optional<Category> findByCategoryId(Long categoryId);

    @Query(
        value = """
            select c
            from Category c
            where (:keyword is null or lower(c.title.value) like %:keyword%)
            and c.owner.value = ?#{principal.username}
            order by c.title.value
        """,
        countQuery = """
            select count(c)
            from Category c
            where (:keyword is null or lower(c.title.value) like %:keyword%)
            and c.owner.value = ?#{principal.username}
        """
    )
    Page<Category> findAll(Pageable pageable,
                           @Nullable @Param("keyword") String keyword);

    @Query("""
        select c
        from Category c
        where c.transactionType = ?1
        and c.owner.value = ?#{principal.username}
    """)
    List<Category> findAllByTransactionType(TransactionType transactionType);

    @Transactional
    @Modifying
    @Query("""
        delete
        from Category c
        where c.categoryId = ?1
        and c.owner.value = ?#{principal.username}
    """)
    void delete(Long categoryId);

}
