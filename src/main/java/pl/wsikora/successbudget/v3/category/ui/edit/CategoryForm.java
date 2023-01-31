package pl.wsikora.successbudget.v3.category.ui.edit;

import lombok.*;
import pl.wsikora.successbudget.v3.category.application.CategoryAttributes;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CategoryForm implements CategoryAttributes {

    static final String F_TITLE = "title";
    static final String F_DESCRIPTION = "description";
    static final String F_ASSIGNED_TRANSACTION_TYPE = "assignedTransactionType";

    private Long categoryId;
    private String title;
    private String description;
    private String assignedTransactionType;

}
