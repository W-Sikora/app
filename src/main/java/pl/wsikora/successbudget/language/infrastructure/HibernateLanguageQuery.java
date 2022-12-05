package pl.wsikora.successbudget.language.infrastructure;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractQuery;
import pl.wsikora.successbudget.language.application.query.LanguageQuery;
import pl.wsikora.successbudget.language.domain.Language;

import java.util.List;

@Service

class HibernateLanguageQuery extends AbstractQuery<Language> implements LanguageQuery {

    @Override
    protected Class<Language> entityClass() {

        return Language.class;
    }

    @Override
    public List<Language> getAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Language> query = criteriaBuilder.createQuery(entityClass());

        Root<Language> rootEntry = query.from(entityClass());

        CriteriaQuery<Language> all = query.select(rootEntry);

        TypedQuery<Language> allQuery = entityManager.createQuery(all);

        return allQuery.getResultList();
    }
}
