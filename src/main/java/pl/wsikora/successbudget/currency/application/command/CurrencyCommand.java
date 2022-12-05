package pl.wsikora.successbudget.currency.application.command;


import pl.wsikora.successbudget.currency.domain.Currency;

public interface CurrencyCommand {

    void save(Currency currency);

    void delete(Long id);
}
