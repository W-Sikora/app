package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsikora.successbudget.v3.cashflow.domain.Expenditure;


interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    Expenditure getByExpenditureId(Long expenditureId);

    @Query("select count(e) > 0 from Expenditure e where e.expenditureId = ?1 and e.owner.value = ?2")
    boolean existsByExpenditureIdAndUsername(Long categoryId, String username);

}
