package pl.wsikora.successbudget.v3.user.ui.edit.preference;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.type.Username;


@Service
public class PreferenceFormFactory {

    PreferenceForm getPreferenceForm(Username username) {

        return new PreferenceForm();
    }

}
