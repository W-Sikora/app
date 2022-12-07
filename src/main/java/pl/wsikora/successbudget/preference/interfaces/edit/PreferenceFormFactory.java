package pl.wsikora.successbudget.preference.interfaces.edit;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.preference.application.query.PreferenceQuery;
import pl.wsikora.successbudget.preference.domain.Preference;

import static java.util.Objects.isNull;


@Service
public class PreferenceFormFactory {

    private final PreferenceQuery preferenceQuery;

    private PreferenceFormFactory(PreferenceQuery preferenceQuery) {

        Assert.notNull(preferenceQuery, "preferenceQuery must not be null");

        this.preferenceQuery = preferenceQuery;
    }

    PreferenceForm getForm(Long id) {

        PreferenceForm form = new PreferenceForm();

        if (isNull(id)) {

            return form;
        }

        return preferenceQuery.findById(id)
                .map(this::convert)
                .orElse(form);
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
