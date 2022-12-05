package pl.wsikora.successbudget.preference.application.query;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.currency.application.query.CurrencyQueryService;
import pl.wsikora.successbudget.language.application.query.LanguageQueryService;
import pl.wsikora.successbudget.preference.domain.Preference;
import pl.wsikora.successbudget.user.application.command.UserQueryService;

@Service
public class PreferenceQueryService {

    private final PreferenceQuery preferenceQuery;
    private final UserQueryService userQueryService;
    private final LanguageQueryService languageQueryService;
    private final CurrencyQueryService currencyQueryService;

    private PreferenceQueryService(PreferenceQuery preferenceQuery, UserQueryService userQueryService, LanguageQueryService languageQueryService, CurrencyQueryService currencyQueryService) {

        this.preferenceQuery = preferenceQuery;
        this.userQueryService = userQueryService;
        this.languageQueryService = languageQueryService;
        this.currencyQueryService = currencyQueryService;
    }

    public PreferenceDto getById(Long id) {

        Preference preference = preferenceQuery.getById(id);

        return convert(preference);
    }

    private PreferenceDto convert(Preference preference) {

        String userName = userQueryService.getUserNameById(preference.getUserId());

        String languageName = languageQueryService.getLanguageNameById(preference.getLanguageId());

        String currencyName = currencyQueryService.getCurrencyNameById(preference.getMainCurrencyId());

        return new PreferenceDto(
                userName,
                languageName,
                currencyName,
                preference.isEnabledCurrencyCodeMode(),
                preference.isEnabledCollaborationMode()
        );
    }
}
