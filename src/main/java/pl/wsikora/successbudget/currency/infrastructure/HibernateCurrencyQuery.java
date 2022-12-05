package pl.wsikora.successbudget.currency.infrastructure;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractQuery;
import pl.wsikora.successbudget.currency.application.query.CurrencyQuery;
import pl.wsikora.successbudget.currency.domain.Currency;

import java.util.List;

@Service

class HibernateCurrencyQuery extends AbstractQuery<Currency> implements CurrencyQuery {

    @Override
    protected Class<Currency> entityClass() {

        return Currency.class;
    }

    @Override
    public List<Currency> getAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Currency> query = criteriaBuilder.createQuery(entityClass());

        Root<Currency> rootEntry = query.from(entityClass());

        CriteriaQuery<Currency> all = query.select(rootEntry);

        TypedQuery<Currency> allQuery = entityManager.createQuery(all);

        return allQuery.getResultList();
    }
}
