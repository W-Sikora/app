package pl.wsikora.successbudget.preference.infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.preference.application.query.PreferenceQuery;
import pl.wsikora.successbudget.preference.domain.Preference;

import java.util.Optional;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.common.CommonMessage.getEntityNotFoundExceptionMessage;

@Service
class HibernatePreferenceQuery implements PreferenceQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Preference getById(Long id) {

        return findById(id).orElseThrow(() -> throwEntityNotFoundExceptionForId(id));
    }

    @Override
    public Optional<Preference> findById(long id) {

        Preference preference = entityManager.find(Preference.class, id);

        return Optional.ofNullable(preference);
    }

    private EntityNotFoundException throwEntityNotFoundExceptionForId(Long id) {

        String message = getEntityNotFoundExceptionMessage(Preference.class, id);

        return new EntityNotFoundException(message);
    }
}
