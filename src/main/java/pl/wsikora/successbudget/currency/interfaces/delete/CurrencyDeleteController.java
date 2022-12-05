package pl.wsikora.successbudget.currency.interfaces.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.currency.application.command.CurrencyCommandService;

import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.currency.interfaces.CurrencyConstant.CURRENCY_DELETE_URL;
import static pl.wsikora.successbudget.currency.interfaces.CurrencyConstant.CURRENCY_VIEW_URL;

@Controller
@RequestMapping(CURRENCY_DELETE_URL)
class CurrencyDeleteController {

    private final CurrencyCommandService currencyCommandService;

    private CurrencyDeleteController(CurrencyCommandService currencyCommandService) {

        this.currencyCommandService = currencyCommandService;
    }

    @PostMapping
    private String delete(@PathVariable Long id) {

        currencyCommandService.delete(id);

        return redirect(CURRENCY_VIEW_URL);
    }
}
