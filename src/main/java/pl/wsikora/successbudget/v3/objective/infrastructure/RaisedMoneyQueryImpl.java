package pl.wsikora.successbudget.v3.objective.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;
import pl.wsikora.successbudget.v3.objective.application.RaisedMoneyDto;
import pl.wsikora.successbudget.v3.objective.application.RaisedMoneyQuery;
import pl.wsikora.successbudget.v3.objective.domain.RaisedMoney;

import java.util.Optional;


@Service
class RaisedMoneyQueryImpl implements RaisedMoneyQuery {

    private final RaisedMoneyRepository raisedMoneyRepository;

    private RaisedMoneyQueryImpl(RaisedMoneyRepository raisedMoneyRepository) {

        this.raisedMoneyRepository = raisedMoneyRepository;
    }

    @Override
    public Optional<RaisedMoneyDto> findByRaisedMoneyId(Long raisedMoneyId) {

        Assert.notNull(raisedMoneyId, "raisedMoneyId must not be null");

        return raisedMoneyRepository.findByRaisedMoneyId(raisedMoneyId)
            .map(this::toDto);
    }

    @Override
    public Page<RaisedMoneyDto> findAll(Pageable pageable, Long objectiveId) {

        Assert.notNull(pageable, "pageable must not be null");
        Assert.notNull(objectiveId, "objectiveId must not be null");

        return raisedMoneyRepository.findAll(pageable, objectiveId)
            .map(this::toDto);
    }

    private RaisedMoneyDto toDto(RaisedMoney raisedMoney) {

        MoneyDto moneyDto = MoneyDtoFactory.create(raisedMoney.getMoney());

        return new RaisedMoneyDto(
            raisedMoney.getRaisedMoneyId(),
            moneyDto,
            raisedMoney.getDate().toString()
        );
    }

}
