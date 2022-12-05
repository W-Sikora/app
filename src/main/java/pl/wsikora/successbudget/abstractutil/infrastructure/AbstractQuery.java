package pl.wsikora.successbudget.abstractutil.infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;

import java.util.Optional;

import static pl.wsikora.successbudget.common.CommonMessage.getEntityNotFoundExceptionMessage;

public abstract class AbstractQuery<Entity extends AbstractEntity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public Entity getById(Long id) {

        return findById(id).orElseThrow(() -> throwEntityNotFoundExceptionForId(id));
    }

    public Optional<Entity> findById(Long id) {

        Entity entity = entityManager.find(entityClass(), id);

        return Optional.ofNullable(entity);
    }

    protected abstract Class<Entity> entityClass();

    private EntityNotFoundException throwEntityNotFoundExceptionForId(Long id) {

        String message = getEntityNotFoundExceptionMessage(entityClass(), id);

        return new EntityNotFoundException(message);
    }
}
