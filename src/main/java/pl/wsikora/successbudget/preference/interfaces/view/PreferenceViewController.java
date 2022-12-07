package pl.wsikora.successbudget.preference.interfaces.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.preference.application.query.PreferenceDto;
import pl.wsikora.successbudget.preference.application.query.PreferenceQueryService;

import static pl.wsikora.successbudget.language.interfaces.LanguageConstant.LANGUAGE_VIEW;
import static pl.wsikora.successbudget.preference.interfaces.PreferenceConstants.PREFERENCE_VIEW_URL;

@Controller
@RequestMapping(PREFERENCE_VIEW_URL)
public class PreferenceViewController {

    private final PreferenceQueryService preferenceQueryService;

    public PreferenceViewController(PreferenceQueryService preferenceQueryService) {

        this.preferenceQueryService = preferenceQueryService;
    }

    @GetMapping
    private String goToView() {

        return LANGUAGE_VIEW;
    }

    @ModelAttribute("preferenceDto")
    private PreferenceDto getPreference(@PathVariable Long id) {

        return preferenceQueryService.getById(id);
    }
}
