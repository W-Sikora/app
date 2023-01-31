package pl.wsikora.successbudget.v3.user.ui.edit.preference;

import lombok.*;
import pl.wsikora.successbudget.v3.user.application.PreferenceFormAttribute;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
class PreferenceForm implements PreferenceFormAttribute {

    static final String F_LANGUAGE_ID = "currencyPresentationMethod";
    static final String F_MAIN_CURRENCY_ID = "mainCurrency";

    private String currencyPresentationMethod;
    private String mainCurrency;

}
