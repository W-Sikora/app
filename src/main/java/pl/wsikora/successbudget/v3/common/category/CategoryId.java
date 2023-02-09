package pl.wsikora.successbudget.v3.common.category;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.io.Serializable;


@Embeddable
@NoArgsConstructor
@Getter
public class CategoryId implements Serializable {

    @Column(name = "category_id")
    private Long value;

    public CategoryId(Long value) {

        Assert.notNull(value, "CategoryId value must not be null");

        this.value = value;
    }

}
