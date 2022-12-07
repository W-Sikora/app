package pl.wsikora.successbudget.user.infrastructure;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractQuery;
import pl.wsikora.successbudget.language.domain.Language;
import pl.wsikora.successbudget.user.application.query.UserQuery;
import pl.wsikora.successbudget.user.domain.User;

import java.util.Optional;

import static pl.wsikora.successbudget.user.domain.User.D_EMAIL;


@Service

class HibernateUserQuery extends AbstractQuery<User> implements UserQuery {

    @Override
    protected Class<User> entityClass() {

        return User.class;
    }

    @Override
    public Optional<User> findByEmail(String email) {

        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(entityClass());

        Root<User> userRoot = criteriaQuery.from(entityClass());

        Predicate userByEmailPredicate = criteriaBuilder.equal(userRoot.get(D_EMAIL), email);

        criteriaQuery.where(userByEmailPredicate);

        TypedQuery<User> query = getEntityManager().createQuery(criteriaQuery);

        try {

            return Optional.of(query.getSingleResult());
        }
        catch (NoResultException exception) {

            return Optional.empty();
        }
    }
}
