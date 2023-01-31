package pl.wsikora.successbudget.v3.category.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.Description;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.user.domain.User;


@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Category {

    @EmbeddedId
    private CategoryId categoryId;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @Embedded
    private TransactionType assignedTransactionType;

    @ManyToOne
    private User ownedByUser;

}
