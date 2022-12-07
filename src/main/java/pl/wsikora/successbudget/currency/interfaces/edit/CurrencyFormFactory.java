package pl.wsikora.successbudget.currency.interfaces.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractFormFactory;
import pl.wsikora.successbudget.currency.application.query.CurrencyQuery;
import pl.wsikora.successbudget.currency.domain.Currency;

@Service
public class CurrencyFormFactory extends AbstractFormFactory<CurrencyForm, Currency> {

    private final CurrencyQuery currencyQuery;

    private CurrencyFormFactory(CurrencyQuery currencyQuery) {

        this.currencyQuery = currencyQuery;
    }

    @Override
    public CurrencyForm getForm(Long id) {

        if (id == null) {

            return new CurrencyForm();
        }

        return convert(currencyQuery.getById(id));
    }

    @Override
    protected CurrencyForm convert(Currency currency) {

        CurrencyForm form = new CurrencyForm();

        form.setId(form.getId());

        form.setName(currency.getName());

        form.setCode(currency.getCode());

        form.setSymbol(currency.getSymbol());

        return form;
    }
}
