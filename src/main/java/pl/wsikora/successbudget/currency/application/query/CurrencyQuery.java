package pl.wsikora.successbudget.currency.application.query;


import pl.wsikora.successbudget.currency.domain.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyQuery {

    Optional<Currency> findById(Long id);

    Currency getById(Long id);

    List<Currency> getAll();
}
