package pl.wsikora.successbudget.preference.application.command;


import pl.wsikora.successbudget.preference.domain.Preference;

public interface PreferenceCommand {

    void save(Preference preference);
}
