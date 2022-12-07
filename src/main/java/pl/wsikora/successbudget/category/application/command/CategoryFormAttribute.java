package pl.wsikora.successbudget.category.application.command;

public interface CategoryFormAttribute {

    Long getId();

    Long getCreatorId();

    String getName();

    Long getParentCategoryId();

    Long getColorId();

    Long getIconId();
}
