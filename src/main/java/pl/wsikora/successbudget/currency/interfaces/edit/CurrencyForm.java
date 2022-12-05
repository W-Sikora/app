package pl.wsikora.successbudget.currency.interfaces.edit;

import pl.wsikora.successbudget.currency.application.command.CurrencyFormAttribute;

class CurrencyForm implements CurrencyFormAttribute {

    static final String F_NAME = "name";
    static final int F_NAME_MAX_LENGTH = 30;
    static final String F_CODE = "code";
    static final int F_CODE_MAX_LENGTH = 2;
    static final String F_SYMBOL = "symbol";
    static final int F_SYMBOL_MAX_LENGTH = 1;

    private Long id;
    private String name;
    private String code;
    private String symbol;

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

    @Override
    public String getSymbol() {

        return symbol;
    }

    public void setSymbol(String symbol) {

        this.symbol = symbol;
    }
}
