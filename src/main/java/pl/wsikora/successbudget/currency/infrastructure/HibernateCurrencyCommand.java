package pl.wsikora.successbudget.currency.infrastructure;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractCommand;
import pl.wsikora.successbudget.currency.application.command.CurrencyCommand;
import pl.wsikora.successbudget.currency.domain.Currency;

@Service
@Transactional
class HibernateCurrencyCommand extends AbstractCommand<Currency> implements CurrencyCommand {

    @Override
    protected Class<Currency> entityClass() {

        return Currency.class;
    }
}

