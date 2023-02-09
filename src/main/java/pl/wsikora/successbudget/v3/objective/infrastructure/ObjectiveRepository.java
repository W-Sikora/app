package pl.wsikora.successbudget.v3.objective.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.objective.domain.Objective;

import java.util.Optional;


@Repository
interface ObjectiveRepository extends JpaRepository<Objective, Long> {

    @Query("""
            select o
            from Objective o
            where o.objectiveId = ?1
            and o.owner.value = ?#{principal.username}
        """)
    Optional<Objective> findByObjectiveId(Long objectiveId);

    @Query("""
            select o
            from Objective o
            where o.owner.value = ?#{principal.username}
            order by o.title.value
        """)
    Page<Objective> findAll(Pageable pageable);

    @Query("""
            select o
            from Objective o
            where concat(
                lower(o.title.value),
                lower(o.description.value)
            ) like %?1%
            and o.owner.value = ?#{principal.username}
            order by o.title.value
    """)
    Page<Objective> findAllByKeyword(Pageable pageable, String keyword);

}
