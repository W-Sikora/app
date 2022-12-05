package pl.wsikora.successbudget.category.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;

@Table
@Entity(name = "categories")
public class Category extends AbstractEntity {

    private String name;

    private Long parentCategoryId;
}
