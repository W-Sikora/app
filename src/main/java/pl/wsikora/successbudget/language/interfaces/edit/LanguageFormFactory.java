package pl.wsikora.successbudget.language.interfaces.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.language.application.query.LanguageQuery;
import pl.wsikora.successbudget.language.domain.Language;

@Service
public class LanguageFormFactory {

    private final LanguageQuery languageQuery;

    private LanguageFormFactory(LanguageQuery languageQuery) {

        this.languageQuery = languageQuery;
    }

    LanguageForm getForm(Long id) {

        if (id == null) {

            return new LanguageForm();
        }

        return convert(languageQuery.getById(id));
    }

    private LanguageForm convert(Language language) {

        LanguageForm languageForm = new LanguageForm();

        languageForm.setId(languageForm.getId());

        languageForm.setName(language.getName());

        return languageForm;
    }
}
