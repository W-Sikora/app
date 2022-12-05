package pl.wsikora.successbudget.language.application.command;


import pl.wsikora.successbudget.language.domain.Language;

public interface LanguageCommand {

    void save(Language language);

    void delete(long id);
}
