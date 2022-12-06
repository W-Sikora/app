package pl.wsikora.successbudget.language.interfaces.edit;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.language.application.command.LanguageCommandService;
import pl.wsikora.successbudget.language.application.command.LanguageFormAttribute;

import javax.validation.Valid;

import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.language.interfaces.LanguageConstant.*;

@Controller
@RequestMapping(LANGUAGE_EDIT_URL)
class LanguageEditController {

    private final LanguageFormFactory languageFormFactory;
    private final LanguageCommandService languageCommandService;
    private final LanguageFormValidator languageFormValidator;

    private LanguageEditController(LanguageFormFactory languageFormFactory,
                                   LanguageCommandService languageCommandService,
                                   LanguageFormValidator languageFormValidator) {

        this.languageFormFactory = languageFormFactory;
        this.languageCommandService = languageCommandService;
        this.languageFormValidator = languageFormValidator;
    }

    @GetMapping
    private String goToView() {

        return LANGUAGE_EDIT_VIEW;
    }

    @ModelAttribute
    private LanguageForm getForm(@RequestParam(required = false) Long id) {

        return languageFormFactory.getForm(id);
    }

    @PostMapping
    private String save(@Valid @ModelAttribute LanguageFormAttribute languageFormAttribute,
                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return LANGUAGE_EDIT_VIEW;
        }

        languageCommandService.save(languageFormAttribute);

        return redirect(LANGUAGE_VIEW_URL);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(languageFormValidator);
    }
}
