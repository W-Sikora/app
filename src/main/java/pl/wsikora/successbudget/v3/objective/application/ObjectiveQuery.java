package pl.wsikora.successbudget.v3.objective.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ObjectiveQuery {

    Optional<ObjectiveDto> findByObjectiveId(Long objectiveId);

    Page<ObjectiveDto> findAll(Pageable pageable, String keyword);

}
