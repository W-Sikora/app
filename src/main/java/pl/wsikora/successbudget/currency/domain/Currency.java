package pl.wsikora.successbudget.currency.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;

@Entity
@Table(name = "currencies")
public class Currency extends AbstractEntity {

    @Column(length = 50, unique = true)
    private String name;

    @Column(length = 3, unique = true)
    private String code;

    @Column(length = 10, unique = true)
    private String symbol;

    public Currency() {

    }

    public String getName() {

        return name;
    }

    public void setName(String currencyName) {

        this.name = currencyName;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getSymbol() {

        return symbol;
    }

    public void setSymbol(String symbol) {

        this.symbol = symbol;
    }
}
