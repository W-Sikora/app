package pl.wsikora.successbudget.language.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;

@Entity
@Table(name = "languages")
public class Language extends AbstractEntity {

    @Column(length = 30, unique = true)
    private String name;

    @Column(length = 2, unique = true)
    private String code;

    public Language() {

    }

    public String getName() {

        return name;
    }

    public void setName(String languageName) {

        this.name = languageName;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }
}
