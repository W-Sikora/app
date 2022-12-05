package pl.wsikora.successbudget.language.interfaces.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.language.application.query.LanguageDto;
import pl.wsikora.successbudget.language.application.query.LanguageQueryService;

import java.util.List;

import static pl.wsikora.successbudget.language.interfaces.LanguageConstant.LANGUAGE_VIEW;
import static pl.wsikora.successbudget.language.interfaces.LanguageConstant.LANGUAGE_VIEW_URL;

@Controller
@RequestMapping(LANGUAGE_VIEW_URL)
public class LanguageViewController {

    private final LanguageQueryService languageQueryService;

    public LanguageViewController(LanguageQueryService languageQueryService) {

        this.languageQueryService = languageQueryService;
    }

    @GetMapping
    private String goToView() {

        return LANGUAGE_VIEW;
    }

    @ModelAttribute
    private List<LanguageDto> getLanguages() {

        return languageQueryService.getAll();
    }
}
