package pl.wsikora.successbudget.language.application.query;


import pl.wsikora.successbudget.language.domain.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageQuery {

    Optional<Language> findById(Long id);

    Language getById(Long id);

    List<Language> getAll();
}
