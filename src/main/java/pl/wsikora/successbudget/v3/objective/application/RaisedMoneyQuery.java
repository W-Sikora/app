package pl.wsikora.successbudget.v3.objective.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface RaisedMoneyQuery {

    Optional<RaisedMoneyDto> findByRaisedMoneyId(Long raisedMoneyId);

    Page<RaisedMoneyDto> findAll(Pageable pageable, Long objectiveId);

}
