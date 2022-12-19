package pl.wsikora.successbudget.preference.infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.preference.application.command.PreferenceCommand;
import pl.wsikora.successbudget.preference.domain.Preference;

import static pl.wsikora.successbudget.common.CommonMessage.getNotNullMessage;

@Service
@Transactional
class HibernatePreferenceCommand implements PreferenceCommand {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Preference preference) {

        notNullEntity(preference);

        if (preference.getUserId() == null) {

            entityManager.persist(preference);

            return;
        }

        entityManager.merge(preference);
    }

    private void notNullEntity(Preference preference) {

        String preferenceClassName = preference.getClass().getSimpleName();

        Assert.notNull(preference, getNotNullMessage(preferenceClassName));
    }
}

