package pl.wsikora.successbudget.language.application.query;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.language.domain.Language;

import java.util.List;

import static pl.wsikora.successbudget.common.CommonMessage.NO_VALUE_FOUND;

@Service
public class LanguageQueryService {

    private final LanguageQuery languageQuery;

    private LanguageQueryService(LanguageQuery languageQuery) {

        this.languageQuery = languageQuery;
    }

    public List<LanguageDto> getAll() {

        return languageQuery.getAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    public String getLanguageNameById(Long id) {

        return languageQuery.findById(id)
                .map(Language::getName)
                .orElse(NO_VALUE_FOUND);
    }

    private LanguageDto convert(Language language) {

        return new LanguageDto(
                language.getId(),
                language.getName(),
                language.getCode()
        );
    }
}
