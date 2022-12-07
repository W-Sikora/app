package pl.wsikora.successbudget.preference.interfaces.edit;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.currency.application.query.CurrencyQueryService;
import pl.wsikora.successbudget.language.application.query.LanguageQueryService;
import pl.wsikora.successbudget.preference.application.command.PreferenceCommandService;

import javax.validation.Valid;

import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.common.currentuser.application.CurrentUserDtoExtractor.extractCurrentUserDto;
import static pl.wsikora.successbudget.preference.interfaces.PreferenceConstants.*;

@Controller
@RequestMapping(PREFERENCE_EDIT_URL)
class PreferenceEditController {

    private final PreferenceFormFactory preferenceFormFactory;
    private final PreferenceCommandService preferenceCommandService;
    private final PreferenceFormValidator preferenceFormValidator;
    private final LanguageQueryService languageQueryService;
    private final CurrencyQueryService currencyQueryService;

    public PreferenceEditController(PreferenceFormFactory preferenceFormFactory,
                                    PreferenceCommandService preferenceCommandService,
                                    PreferenceFormValidator preferenceFormValidator,
                                    LanguageQueryService languageQueryService,
                                    CurrencyQueryService currencyQueryService) {

        this.preferenceFormFactory = preferenceFormFactory;
        this.preferenceCommandService = preferenceCommandService;
        this.preferenceFormValidator = preferenceFormValidator;
        this.languageQueryService = languageQueryService;
        this.currencyQueryService = currencyQueryService;
    }

    @GetMapping
    private String goToView() {

        return PREFERENCE_EDIT_VIEW;
    }

    @ModelAttribute
    private void initData(@RequestParam Long id, Authentication authentication, ModelMap modelMap) {

        modelMap.addAttribute("preferenceForm", preferenceFormFactory.getForm(id))
                .addAttribute("currentlyLoggedInUser", extractCurrentUserDto(authentication))
                .addAttribute("languages", languageQueryService.getAll())
                .addAttribute("currencies", currencyQueryService.getAll());
    }

    @PostMapping
    private String save(@Valid PreferenceForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return PREFERENCE_EDIT_VIEW;
        }

        preferenceCommandService.save(form);

        return redirect(PREFERENCE_VIEW_URL);
    }

    @InitBinder("preferenceFormValidator")
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(preferenceFormValidator);
    }
}
