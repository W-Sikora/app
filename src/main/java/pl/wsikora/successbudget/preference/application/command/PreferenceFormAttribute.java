package pl.wsikora.successbudget.preference.application.command;

public interface PreferenceFormAttribute {

    Long getUserId();

    Long getLanguageId();

    Long getMainCurrencyId();

    boolean isEnabledCurrencyCodeMode();

    boolean isEnabledCollaborationMode();
}
