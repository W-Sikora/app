package pl.wsikora.successbudget.category.interfaces.edit;

import pl.wsikora.successbudget.category.application.command.CategoryFormAttribute;


public class CategoryForm implements CategoryFormAttribute {

    private Long id;
    private Long creatorId;
    private String name;
    private Long parentCategoryId;
    private Long colorId;
    private Long iconId;

    @Override
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Override
    public Long getCreatorId() {

        return creatorId;
    }

    public void setCreatorId(Long creatorId) {

        this.creatorId = creatorId;
    }

    @Override
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public Long getParentCategoryId() {

        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {

        this.parentCategoryId = parentCategoryId;
    }

    @Override
    public Long getColorId() {

        return colorId;
    }

    public void setColorId(Long colorId) {

        this.colorId = colorId;
    }

    @Override
    public Long getIconId() {

        return iconId;
    }

    public void setIconId(Long iconId) {

        this.iconId = iconId;
    }
}
