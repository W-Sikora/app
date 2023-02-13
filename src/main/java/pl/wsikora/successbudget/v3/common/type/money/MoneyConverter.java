package pl.wsikora.successbudget.v3.common.type.money;

import org.springframework.context.i18n.LocaleContextHolder;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;


public class MoneyConverter {

    private MoneyConverter() {}

    public static Money convert(MoneyDto moneyDto) {

        Currency currency = Currency.of(moneyDto.getCurrency());

        BigDecimal value = fromFormattedValue(moneyDto.getFormattedValue());

        return new Money(currency, value);
    }

    private static BigDecimal fromFormattedValue(String formattedValue) {

        Locale locale = LocaleContextHolder.getLocale();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);

        DecimalFormat formatter = new DecimalFormat("#,##0.00", symbols);

        formatter.setParseBigDecimal(true);

        try {

            return (BigDecimal) formatter.parse(formattedValue);
        }
        catch (ParseException e) {

            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

}
