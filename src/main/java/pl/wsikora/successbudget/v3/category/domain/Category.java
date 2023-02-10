package pl.wsikora.successbudget.v3.category.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.type.title.Title;
import pl.wsikora.successbudget.v3.common.type.username.Username;


@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Embedded
    private Username owner;

    @Embedded
    private Title title;

    @Embedded
    private TransactionType transactionType;

}
