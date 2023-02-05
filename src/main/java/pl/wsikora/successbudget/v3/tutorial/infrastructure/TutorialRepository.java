package pl.wsikora.successbudget.v3.tutorial.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.tutorial.domain.Tutorial;


@Repository
interface TutorialRepository extends JpaRepository<Tutorial, Username> {

    @Query("""
        select t.lastCompletedStep
        from Tutorial t
        where t.username.value = ?#{principal.username}
    """)
    int getLastCompletedStep();

}
