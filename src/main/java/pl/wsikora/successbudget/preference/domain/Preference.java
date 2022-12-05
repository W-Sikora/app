package pl.wsikora.successbudget.preference.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "preferences")
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private Long languageId;

    private Long mainCurrencyId;

    private boolean enabledCurrencyCodeMode;

    private boolean enabledCollaborationMode;

    public Preference() {

    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public Long getLanguageId() {

        return languageId;
    }

    public void setLanguageId(Long languageId) {

        this.languageId = languageId;
    }

    public Long getMainCurrencyId() {

        return mainCurrencyId;
    }

    public void setMainCurrencyId(Long mainCurrencyId) {

        this.mainCurrencyId = mainCurrencyId;
    }

    public boolean isEnabledCurrencyCodeMode() {

        return enabledCurrencyCodeMode;
    }

    public void setEnabledCurrencyCodeMode(boolean presentCurrencyCodeMode) {

        this.enabledCurrencyCodeMode = presentCurrencyCodeMode;
    }

    public boolean isEnabledCollaborationMode() {

        return enabledCollaborationMode;
    }

    public void setEnabledCollaborationMode(boolean collaborationMode) {

        this.enabledCollaborationMode = collaborationMode;
    }
}
