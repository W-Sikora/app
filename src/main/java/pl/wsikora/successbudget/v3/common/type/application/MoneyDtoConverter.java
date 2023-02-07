package pl.wsikora.successbudget.v3.common.type.application;

import pl.wsikora.successbudget.v3.common.type.Money;

import java.util.Set;

import static java.util.stream.Collectors.toSet;


public class MoneyDtoConverter {

    private MoneyDtoConverter() {}

    public static MoneyDto convert(Money money) {

        return new MoneyDto(
            money.getCurrency().ordinal(),
            money.getValue()
        );
    }

    public static Set<MoneyDto> convert(Set<Money> moneySet) {

        return moneySet.stream()
            .map(MoneyDtoConverter::convert)
            .collect(toSet());
    }

}
