package pl.wsikora.successbudget.v3.category.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.category.TransactionType;
import pl.wsikora.successbudget.v3.common.username.Username;


@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Embedded
    private Title title;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType assignedTransactionType;

    @Embedded
    private Username owner;

}
