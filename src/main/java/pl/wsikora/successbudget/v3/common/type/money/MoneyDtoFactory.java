package pl.wsikora.successbudget.v3.common.type.money;

import org.springframework.context.i18n.LocaleContextHolder;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Set;

import static java.util.stream.Collectors.toSet;


public class MoneyDtoFactory {

    private static final String DECIMAL_FORMAT = "###,###.00";

    private MoneyDtoFactory() {}

    public static MoneyDto convert(Money money) {

        BigDecimal value = money.getValue();

        String formattedValue = formatValue(value);

        return new MoneyDto(
            money.getCurrency().getValue(),
            value,
            formattedValue
        );
    }

    public static Set<MoneyDto> convert(Set<Money> moneySet) {

        return moneySet.stream()
            .map(MoneyDtoFactory::convert)
            .collect(toSet());
    }

    private static String formatValue(BigDecimal value) {

        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(LocaleContextHolder.getLocale());

        formatSymbols.setGroupingSeparator(' ');

        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT, formatSymbols);

        return formatter.format(value);
    }

}
