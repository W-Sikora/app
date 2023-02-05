package pl.wsikora.successbudget.v3.objective.application;

import java.util.Optional;


public interface ObjectiveQuery {

    Optional<ObjectiveDto> findByObjectiveId(Long objectiveId);

}
