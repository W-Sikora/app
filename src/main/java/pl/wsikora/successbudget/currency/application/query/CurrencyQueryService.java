package pl.wsikora.successbudget.currency.application.query;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.currency.domain.Currency;

import java.util.List;

import static pl.wsikora.successbudget.common.CommonMessage.NO_VALUE_FOUND;

@Service
public class CurrencyQueryService {

    private final CurrencyQuery currencyQuery;

    private CurrencyQueryService(CurrencyQuery currencyQuery) {

        this.currencyQuery = currencyQuery;
    }

    public List<CurrencyDto> getAll() {

        return currencyQuery.getAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    public String getCurrencyNameById(Long id) {

        return currencyQuery.findById(id)
                .map(Currency::getName)
                .orElse(NO_VALUE_FOUND);
    }

    private CurrencyDto convert(Currency currency) {

        return new CurrencyDto(
                currency.getValue(),
                currency.getName(),
                currency.getCode(),
                currency.getSymbol()
        );
    }
}
