package pl.wsikora.successbudget.v3.objective.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.money.MoneyDtoConverter;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveDto;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveQuery;
import pl.wsikora.successbudget.v3.objective.domain.Objective;

import java.util.Locale;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;


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
    public Page<ObjectiveDto> findAll(Pageable pageable, String keyword) {

        if (hasText(keyword)) {

            return objectiveRepository.findAllByKeyword(pageable, keyword.toLowerCase(Locale.ROOT))
                .map(this::toDto);
        }

        return objectiveRepository.findAll(pageable)
            .map(this::toDto);
    }

    private ObjectiveDto toDto(Objective objective) {

        MoneyDto necessaryMoney = MoneyDtoConverter.convert(objective.getNecessaryMoney());

//        objective.getRaisedMoney()

//        Set<MoneyDto> raisedMoney = MoneyDtoConverter.convert();

        return new ObjectiveDto(
            objective.getObjectiveId(),
            objective.getTitle().getValue(),
            objective.getDescription().getValue(),
            necessaryMoney,
            necessaryMoney, ///TO DO
            objective.isRealized()
        );
    }

}
