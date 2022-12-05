package pl.wsikora.successbudget.preference.application.command;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.preference.domain.Preference;

@Service
public class PreferenceCommandService {

    private final PreferenceCommand preferenceCommand;

    public PreferenceCommandService(PreferenceCommand preferenceCommand) {

        this.preferenceCommand = preferenceCommand;
    }

    public void save(PreferenceFormAttribute attribute) {

        Preference preference = convert(attribute);

        preferenceCommand.save(preference);
    }

    private Preference convert(PreferenceFormAttribute attribute) {

        Preference preference = new Preference();

        preference.setUserId(attribute.getUserId());

        preference.setLanguageId(attribute.getLanguageId());

        preference.setMainCurrencyId(attribute.getMainCurrencyId());

        preference.setEnabledCurrencyCodeMode(attribute.isEnabledCurrencyCodeMode());

        preference.setEnabledCollaborationMode(attribute.isEnabledCollaborationMode());

        return preference;
    }
}
