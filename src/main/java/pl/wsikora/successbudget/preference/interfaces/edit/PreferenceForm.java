package pl.wsikora.successbudget.preference.interfaces.edit;

import pl.wsikora.successbudget.preference.application.command.PreferenceFormAttribute;

class PreferenceForm implements PreferenceFormAttribute {

    static final String F_USER_ID = "userId";
    static final String F_LANGUAGE_ID = "languageId";
    static final String F_MAIN_CURRENCY_ID = "mainCurrencyId";

    private Long userId;
    private Long languageId;
    private Long mainCurrencyId;
    private boolean enabledCurrencyCodeMode;
    private boolean enabledCollaborationMode;

    @Override
    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    @Override
    public Long getLanguageId() {

        return languageId;
    }

    public void setLanguageId(Long languageId) {

        this.languageId = languageId;
    }

    @Override
    public Long getMainCurrencyId() {

        return mainCurrencyId;
    }

    public void setMainCurrencyId(Long mainCurrencyId) {

        this.mainCurrencyId = mainCurrencyId;
    }

    @Override
    public boolean isEnabledCurrencyCodeMode() {

        return enabledCurrencyCodeMode;
    }

    public void setEnabledCurrencyCodeMode(boolean enabledCurrencyCodeMode) {

        this.enabledCurrencyCodeMode = enabledCurrencyCodeMode;
    }

    @Override
    public boolean isEnabledCollaborationMode() {

        return enabledCollaborationMode;
    }

    public void setEnabledCollaborationMode(boolean enabledCollaborationMode) {

        this.enabledCollaborationMode = enabledCollaborationMode;
    }
}
