package pl.wsikora.successbudget.currency.application.command;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.currency.domain.Currency;


@Service
public class CurrencyCommandService {

    private final CurrencyCommand currencyCommand;

    public CurrencyCommandService(CurrencyCommand currencyCommand) {

        this.currencyCommand = currencyCommand;
    }

    public void save(CurrencyFormAttribute attribute) {

        Currency currency = convert(attribute);

        currencyCommand.save(currency);
    }

    public void delete(Long id) {

        currencyCommand.delete(id);
    }

    private Currency convert(CurrencyFormAttribute attribute) {

        Currency currency = new Currency();

        currency.setId(attribute.getId());

        currency.setName(attribute.getName());

        currency.setCode(attribute.getCode());

        currency.setSymbol(attribute.getSymbol());

        return currency;
    }
}
