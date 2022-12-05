package pl.wsikora.successbudget.language.interfaces.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.language.application.command.LanguageCommandService;

import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.language.interfaces.LanguageConstant.LANGUAGE_DELETE_URL;
import static pl.wsikora.successbudget.language.interfaces.LanguageConstant.LANGUAGE_VIEW_URL;

@Controller
@RequestMapping(LANGUAGE_DELETE_URL)
class LanguageDeleteController {

    private final LanguageCommandService languageCommandService;

    private LanguageDeleteController(LanguageCommandService languageCommandService) {

        this.languageCommandService = languageCommandService;
    }

    @PostMapping
    private String delete(@PathVariable Long id) {

        languageCommandService.delete(id);

        return redirect(LANGUAGE_VIEW_URL);
    }
}
