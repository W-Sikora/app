package pl.wsikora.successbudget.currency.interfaces.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.currency.application.query.CurrencyDto;
import pl.wsikora.successbudget.currency.application.query.CurrencyQueryService;

import java.util.List;

import static pl.wsikora.successbudget.currency.interfaces.CurrencyConstant.CURRENCY_VIEW;
import static pl.wsikora.successbudget.currency.interfaces.CurrencyConstant.CURRENCY_VIEW_URL;

@Controller
@RequestMapping(CURRENCY_VIEW_URL)
public class CurrencyViewController {

    private final CurrencyQueryService currencyQueryService;

    public CurrencyViewController(CurrencyQueryService currencyQueryService) {

        this.currencyQueryService = currencyQueryService;
    }

    @GetMapping
    private String goToView() {

        return CURRENCY_VIEW;
    }

    @ModelAttribute
    private List<CurrencyDto> getLanguages() {

        return currencyQueryService.getAll();
    }
}
