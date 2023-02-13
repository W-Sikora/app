package pl.wsikora.successbudget.v3.common.type.categoryid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;


@Embeddable
@NoArgsConstructor
@Getter
public class CategoryId {

    @Column(name = "category_id")
    private Long value;

    private CategoryId(Long value) {

        this.value = value;
    }

    public static CategoryId of(Long value) {

        Assert.notNull(value, "CategoryId value must not be null");

        return new CategoryId(value);
    }

}
