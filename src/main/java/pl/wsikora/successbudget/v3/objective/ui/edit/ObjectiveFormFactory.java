package pl.wsikora.successbudget.v3.objective.ui.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.application.MoneyDto;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveDto;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveQuery;


@Service
class ObjectiveFormFactory {

    private final ObjectiveQuery objectiveQuery;

    private ObjectiveFormFactory(ObjectiveQuery objectiveQuery) {

        this.objectiveQuery = objectiveQuery;
    }

    ObjectiveForm getObjectiveForm(Long objectiveId) {

        return objectiveQuery.findByObjectiveId(objectiveId)
            .map(this::toForm)
            .orElseGet(ObjectiveForm::new);
    }

    private ObjectiveForm toForm(ObjectiveDto objectiveDto) {

        MoneyDto necessaryMoneyDto = objectiveDto.getNecessaryMoneyDto();

        return ObjectiveForm.builder()
            .objectiveId(objectiveDto.getObjectiveId())
            .title(objectiveDto.getTitle())
            .description(objectiveDto.getDescription())
            .necessaryMoneyCurrencyId(necessaryMoneyDto.getCurrencyId())
            .necessaryMoneyValue(necessaryMoneyDto.getValue())
            .build();
    }

}
