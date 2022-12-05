package pl.wsikora.successbudget.language.interfaces.edit;

import org.springframework.stereotype.Component;
import pl.wsikora.successbudget.language.application.command.LanguageFormAttribute;

@Component
class LanguageForm implements LanguageFormAttribute {

    static final String F_NAME = "name";
    static final int F_NAME_MAX_LENGTH = 30;
    static final String F_CODE = "code";
    static final int F_CODE_MAX_LENGTH = 2;

    private Long id;
    private String name;
    private String code;

    @Override
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Override
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }
}
