package pl.wsikora.successbudget.currency.interfaces.edit;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.currency.application.command.CurrencyCommandService;
import pl.wsikora.successbudget.currency.application.command.CurrencyFormAttribute;

import javax.validation.Valid;

import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.currency.interfaces.CurrencyConstant.*;
import static pl.wsikora.successbudget.language.interfaces.LanguageConstant.LANGUAGE_EDIT_VIEW;

@Controller
@RequestMapping(CURRENCY_EDIT_URL)
class CurrencyEditController {

    private final CurrencyFormFactory currencyFormFactory;
    private final CurrencyCommandService currencyCommandService;
    private final CurrencyFormValidator currencyFormValidator;

    private CurrencyEditController(CurrencyFormFactory currencyFormFactory,
                                   CurrencyCommandService currencyCommandService,
                                   CurrencyFormValidator currencyFormValidator) {

        this.currencyFormFactory = currencyFormFactory;
        this.currencyCommandService = currencyCommandService;
        this.currencyFormValidator = currencyFormValidator;
    }

    @GetMapping
    private String goToView() {

        return CURRENCY_EDIT_VIEW;
    }

    @ModelAttribute
    private CurrencyForm getForm(@RequestParam(required = false) Long id) {

        return currencyFormFactory.getForm(id);
    }

    @PostMapping
    private String save(@Valid @ModelAttribute CurrencyFormAttribute currencyFormAttribute,
                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return LANGUAGE_EDIT_VIEW;
        }

        currencyCommandService.save(currencyFormAttribute);

        return redirect(CURRENCY_VIEW_URL);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(currencyFormValidator);
    }
}
