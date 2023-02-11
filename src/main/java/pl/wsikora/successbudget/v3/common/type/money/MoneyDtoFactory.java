package pl.wsikora.successbudget.v3.common.type.money;

import org.springframework.context.i18n.LocaleContextHolder;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Set;

import static java.util.stream.Collectors.toSet;


public class MoneyDtoFactory {

    private MoneyDtoFactory() {}

    public static MoneyDto create(Money money) {

        BigDecimal value = money.getValue();

        String formattedValue = formatValue(value);

        return new MoneyDto(
            money,
            formattedValue
        );
    }

    public static Set<MoneyDto> create(Set<Money> moneySet) {

        return moneySet.stream()
            .map(MoneyDtoFactory::create)
            .collect(toSet());
    }

    private static String formatValue(BigDecimal value) {

        Locale locale = LocaleContextHolder.getLocale();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);

        DecimalFormat formatter = new DecimalFormat("#,##0.00", symbols);

        return formatter.format(value);
    }

}
