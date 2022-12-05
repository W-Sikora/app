package pl.wsikora.successbudget.category.application.query;

public class CategoryDto {

    private final Long id;
    private final String name;
    private final String code;
    private final String symbol;

    public CategoryDto(Long id, String name, String code, String symbol) {

        this.id = id;
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getCode() {

        return code;
    }

    public String getSymbol() {

        return symbol;
    }
}
