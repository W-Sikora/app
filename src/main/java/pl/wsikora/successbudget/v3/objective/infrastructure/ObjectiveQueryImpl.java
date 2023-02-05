package pl.wsikora.successbudget.v3.objective.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveDto;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveQuery;

import java.util.Optional;

@Service
public class ObjectiveQueryImpl implements ObjectiveQuery {

    @Override
    public Optional<ObjectiveDto> findByObjectiveId(Long objectiveId) {

        return Optional.empty();
    }
}
