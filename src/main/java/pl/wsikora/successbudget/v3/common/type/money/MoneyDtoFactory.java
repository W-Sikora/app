package pl.wsikora.successbudget.v3.common.type.money;

import pl.wsikora.successbudget.v3.common.type.currency.Currency;

import java.util.Set;

import static java.util.stream.Collectors.toSet;


public class MoneyDtoFactory {

    private MoneyDtoFactory() {}

    public static MoneyDto create(Money money) {

        Currency currency = money.getCurrency();

        return new MoneyDto(
            currency.ordinal(),
            currency.getSign(),
            money.getFormattedValue(),
            money.isLessThanZero()
        );
    }

    public static Set<MoneyDto> create(Set<Money> moneySet) {

        return moneySet.stream()
            .map(MoneyDtoFactory::create)
            .collect(toSet());
    }



}
