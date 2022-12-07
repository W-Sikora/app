package pl.wsikora.successbudget.preference.application.query;


import pl.wsikora.successbudget.preference.domain.Preference;

import java.util.Optional;


public interface PreferenceQuery {

    Optional<Preference> findById(long id);

    Preference getById(Long id);


}
