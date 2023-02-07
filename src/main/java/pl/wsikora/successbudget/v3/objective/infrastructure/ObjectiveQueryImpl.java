package pl.wsikora.successbudget.v3.objective.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.application.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.application.MoneyDtoConverter;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveDto;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveQuery;
import pl.wsikora.successbudget.v3.objective.domain.Objective;

import java.util.Optional;
import java.util.Set;


@Service
class ObjectiveQueryImpl implements ObjectiveQuery {

    private final ObjectiveRepository objectiveRepository;

    private ObjectiveQueryImpl(ObjectiveRepository objectiveRepository) {

        this.objectiveRepository = objectiveRepository;
    }

    @Override
    public Optional<ObjectiveDto> findByObjectiveId(Long objectiveId) {

        Assert.notNull(objectiveId, "objectiveId must not be null");

        return objectiveRepository.findByObjectiveId(objectiveId)
            .map(this::toDto);
    }

    @Override
    public Page<ObjectiveDto> findAll(Pageable pageable) {

        Assert.notNull(pageable, "pageable must not be null");

        return objectiveRepository.findAll(pageable)
            .map(this::toDto);
    }

    private ObjectiveDto toDto(Objective objective) {

        MoneyDto necessaryMoney = MoneyDtoConverter.convert(objective.getNecessaryMoney());

        Set<MoneyDto> raisedMoney = MoneyDtoConverter.convert(objective.getRaisedMoney());

        return new ObjectiveDto(
            objective.getObjectiveId(),
            objective.getTitle().getValue(),
            objective.getDescription().getValue(),
            necessaryMoney,
            raisedMoney,
            objective.isRealized()
        );
    }

}
