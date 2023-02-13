package pl.wsikora.successbudget.v3.objective.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.currencyrate.CurrencyRateConverter;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveDto;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveQuery;
import pl.wsikora.successbudget.v3.objective.domain.Objective;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;


@Service
class ObjectiveQueryImpl implements ObjectiveQuery {

    private final ObjectiveRepository objectiveRepository;
    private final RaisedMoneyRepository raisedMoneyRepository;
    private final CurrencyRateConverter currencyRateConverter;

    private ObjectiveQueryImpl(ObjectiveRepository objectiveRepository,
                               RaisedMoneyRepository raisedMoneyRepository,
                               CurrencyRateConverter currencyRateConverter) {

        this.objectiveRepository = objectiveRepository;
        this.raisedMoneyRepository = raisedMoneyRepository;
        this.currencyRateConverter = currencyRateConverter;
    }

    @Override
    public Optional<ObjectiveDto> findByObjectiveId(Long objectiveId) {

        Assert.notNull(objectiveId, "objectiveId must not be null");

        return objectiveRepository.findByObjectiveId(objectiveId)
            .map(this::toDto);
    }

    @Override
    public Page<ObjectiveDto> findAll(Pageable pageable, @Nullable String keyword) {

        Assert.notNull(pageable, "pageable must not be null");

        if (hasText(keyword)) {

            return objectiveRepository.findAllByKeyword(pageable, keyword.toLowerCase(Locale.ROOT))
                .map(this::toDto);
        }

        return objectiveRepository.findAll(pageable)
            .map(this::toDto);
    }

    private ObjectiveDto toDto(Objective objective) {

        Long objectiveId = objective.getObjectiveId();

        Money necessaryMoney = objective.getNecessaryMoney();

        MoneyDto necessaryMoneyDto = MoneyDtoFactory.create(necessaryMoney);

        List<Money> moneys = raisedMoneyRepository.findAllMoney(objectiveId);

        Money raisedMoney = currencyRateConverter.convert(moneys, necessaryMoney.getCurrency());

        return new ObjectiveDto(
            objectiveId,
            objective.getTitle().getValue(),
            objective.getDescription().getValue(),
            necessaryMoneyDto,
            objective.isRealized(),
            MoneyDtoFactory.create(raisedMoney)
        );
    }

}
