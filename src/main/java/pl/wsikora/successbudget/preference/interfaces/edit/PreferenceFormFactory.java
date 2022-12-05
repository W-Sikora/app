package pl.wsikora.successbudget.preference.interfaces.edit;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.preference.application.query.PreferenceQuery;
import pl.wsikora.successbudget.preference.domain.Preference;

@Service
public class PreferenceFormFactory {

    private final PreferenceQuery preferenceQuery;

    private PreferenceFormFactory(PreferenceQuery preferenceQuery) {

        this.preferenceQuery = preferenceQuery;
    }

    PreferenceForm getForm(Long id) {

        if (id == null) {

            return new PreferenceForm();
        }

        return convert(preferenceQuery.getById(id));
    }

    private PreferenceForm convert(Preference preference) {

        PreferenceForm form = new PreferenceForm();

        form.setUserId(preference.getUserId());

        form.setLanguageId(preference.getLanguageId());

        form.setMainCurrencyId(preference.getMainCurrencyId());

        form.setEnabledCurrencyCodeMode(preference.isEnabledCurrencyCodeMode());

        form.setEnabledCollaborationMode(preference.isEnabledCollaborationMode());

        return form;
    }
}
