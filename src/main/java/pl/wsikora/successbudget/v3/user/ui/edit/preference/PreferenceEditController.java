package pl.wsikora.successbudget.v3.user.ui.edit.preference;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.common.type.Username;

import javax.validation.Valid;

import java.security.Principal;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.ControllerUtils.getEditFormName;
import static pl.wsikora.successbudget.v3.common.Redirector.redirect;
import static pl.wsikora.successbudget.v3.user.ui.PreferenceConstants.*;

@Controller
@RequestMapping(PREFERENCE_EDIT_URL)
class PreferenceEditController {

    private final PreferenceFormFactory preferenceFormFactory;
    private final PreferenceFormValidator preferenceFormValidator;

    private PreferenceEditController(PreferenceFormFactory preferenceFormFactory,
                                     PreferenceFormValidator preferenceFormValidator) {

        this.preferenceFormFactory = preferenceFormFactory;
        this.preferenceFormValidator = preferenceFormValidator;
    }

    @GetMapping
    private String goToView() {

        return EDIT_VIEW;
    }

    @ModelAttribute
    private void initData(Principal principal, ModelMap modelMap) {

        Username username = new Username(principal.getName());

        modelMap.addAttribute(FORM_PAGE, getEditFormName(PREFERENCE))
                .addAttribute(PAGE_TITLE, "Ustawianie preferencji użytkownika")
                .addAttribute(PREFERENCE + FORM_SUFIX, preferenceFormFactory.getPreferenceForm(username));
//                .addAttribute("currentlyLoggedInUser", extractCurrentUserDto(authentication))
//                .addAttribute("languages", languageQueryService.getAll())
//                .addAttribute("currencies", currencyQueryService.getAll());
    }

    @PostMapping
    private String save(@Valid @ModelAttribute PreferenceForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return EDIT_VIEW;
        }

//        preferenceCommandService.save(form);

        return redirect(PREFERENCE_VIEW_URL);
    }

    @InitBinder("preferenceFormValidator")
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(preferenceFormValidator);
    }
}
