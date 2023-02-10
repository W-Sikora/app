package pl.wsikora.successbudget.v3.category.ui.edit;

import lombok.*;
import pl.wsikora.successbudget.v3.category.application.CategoryAttributes;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CategoryForm implements CategoryAttributes {

    private Long categoryId;
    private String title;
    private Integer transactionType;

}
