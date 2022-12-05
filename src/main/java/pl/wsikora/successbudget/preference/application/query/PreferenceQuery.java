package pl.wsikora.successbudget.preference.application.query;


import pl.wsikora.successbudget.preference.domain.Preference;

public interface PreferenceQuery {

    Preference getById(Long id);
}
