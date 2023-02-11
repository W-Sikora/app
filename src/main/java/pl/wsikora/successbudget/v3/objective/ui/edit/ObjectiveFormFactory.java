package pl.wsikora.successbudget.v3.objective.ui.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
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

        Money money = necessaryMoneyDto.getMoney();

        return ObjectiveForm.builder()
            .objectiveId(objectiveDto.getObjectiveId())
            .title(objectiveDto.getTitle())
            .description(objectiveDto.getDescription())
            .necessaryMoneyCurrencyId(money.getCurrency().ordinal())
            .necessaryMoneyValue(money.getValue())
            .build();
    }

}
