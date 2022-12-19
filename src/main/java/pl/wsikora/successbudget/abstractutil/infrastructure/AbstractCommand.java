package pl.wsikora.successbudget.abstractutil.infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;

import static pl.wsikora.successbudget.common.CommonMessage.getNotNullMessage;

public abstract class AbstractCommand<Entity extends AbstractEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Entity entity) {

        notNullEntity(entity);

        if (entity.getValue() == null) {

            entityManager.persist(entity);

            return;
        }

        entityManager.merge(entity);
    }

    @Transactional
    public void delete(Entity entity) {

        notNullEntity(entity);

        entityManager.remove(entity);
    }

    @Transactional
    public void delete(long id) {

        Entity entity = entityManager.find(entityClass(), id);

        notNullEntity(entity);

        delete(entity);
    }

    protected abstract Class<Entity> entityClass();

    private void notNullEntity(Entity entity) {

        String entityClassName = entityClass().getSimpleName();

        Assert.notNull(entity, getNotNullMessage(entityClassName));
    }
}
