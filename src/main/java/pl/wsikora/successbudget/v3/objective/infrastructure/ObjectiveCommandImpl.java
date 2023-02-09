package pl.wsikora.successbudget.v3.objective.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.exception.NotFoundException;
import pl.wsikora.successbudget.v3.common.money.Money;
import pl.wsikora.successbudget.v3.common.type.Currency;
import pl.wsikora.successbudget.v3.common.type.Description;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.username.UsernameProvider;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveAttributes;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveCommand;
import pl.wsikora.successbudget.v3.objective.domain.Objective;


@Service
class ObjectiveCommandImpl implements ObjectiveCommand {

    private final ObjectiveRepository objectiveRepository;
    private final UsernameProvider usernameProvider;

    private ObjectiveCommandImpl(ObjectiveRepository objectiveRepository,
                                 UsernameProvider usernameProvider) {

        this.objectiveRepository = objectiveRepository;
        this.usernameProvider = usernameProvider;
    }

    @Override
    public void save(ObjectiveAttributes objectiveAttributes) {

        Assert.notNull(objectiveAttributes, "objectiveAttributes must not be null");

        Objective objective = new Objective();

        objective.setOwner(usernameProvider.getUsername());

        objective.setTitle(new Title(objectiveAttributes.getTitle()));

        objective.setDescription(new Description(objectiveAttributes.getDescription()));

        Currency currency = Currency.getByCurrencyId(objectiveAttributes.getNecessaryMoneyCurrencyId());

        Money money = new Money(
            currency,
            objectiveAttributes.getNecessaryMoneyValue()
        );

        objective.setNecessaryMoney(money);

        objective.setRealized(objectiveAttributes.isRealized());

        objectiveRepository.save(objective);
    }

    @Override
    public void realized(Long objectiveId) {

        Assert.notNull(objectiveId, "objectiveId must not be null");

        Objective objective = objectiveRepository.findByObjectiveId(objectiveId)
            .orElseThrow(() -> new NotFoundException("objective", objectiveId));

        objective.setRealized(true);

        objectiveRepository.save(objective);
    }

}
