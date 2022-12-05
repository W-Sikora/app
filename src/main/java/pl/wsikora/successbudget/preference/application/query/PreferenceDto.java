package pl.wsikora.successbudget.preference.application.query;

public record PreferenceDto(String userName,
                            String language,
                            String mainCurrency,
                            boolean enabledCurrencyCodeMode,
                            boolean enabledCollaborationMode) {

}
