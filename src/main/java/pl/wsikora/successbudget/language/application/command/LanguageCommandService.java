package pl.wsikora.successbudget.language.application.command;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.language.domain.Language;


@Service
public class LanguageCommandService {

    private final LanguageCommand languageCommand;

    public LanguageCommandService(LanguageCommand languageCommand) {

        this.languageCommand = languageCommand;
    }

    public void save(LanguageFormAttribute attribute) {

        Language language = convert(attribute);

        languageCommand.save(language);
    }

    public void delete(Long id) {

        languageCommand.delete(id);
    }

    protected Language convert(LanguageFormAttribute attribute) {

        Language language = new Language();

        language.setId(attribute.getId());

        language.setName(attribute.getName());

        language.setCode(attribute.getCode());

        return language;
    }
}
