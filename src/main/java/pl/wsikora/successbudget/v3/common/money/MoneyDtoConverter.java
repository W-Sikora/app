package pl.wsikora.successbudget.v3.common.money;

import org.springframework.context.i18n.LocaleContextHolder;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Set;

import static java.util.stream.Collectors.toSet;


public class MoneyDtoConverter {

    private static final String DECIMAL_FORMAT = "###,###.00";

    private MoneyDtoConverter() {}

    public static MoneyDto convert(Money money) {

        BigDecimal value = money.getValue();

        String formattedValue = formatValue(value);

        return new MoneyDto(
            money.getCurrency().ordinal(),
            value,
            formattedValue
        );
    }

    public static Set<MoneyDto> convert(Set<Money> moneySet) {

        return moneySet.stream()
            .map(MoneyDtoConverter::convert)
            .collect(toSet());
    }

    private static String formatValue(BigDecimal value) {

        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(LocaleContextHolder.getLocale());

        formatSymbols.setGroupingSeparator(' ');

        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT, formatSymbols);

        return formatter.format(value);
    }

}
