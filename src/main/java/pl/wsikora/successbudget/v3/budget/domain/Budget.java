package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsikora.successbudget.v3.common.type.BudgetId;
import pl.wsikora.successbudget.v3.common.type.Description;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.user.domain.User;

import java.util.List;


@Entity
@Table(name = "budgets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Budget {

    @EmbeddedId
    private BudgetId budgetId;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<User> users;

//    @OneToMany
//    private List<PlannedRevenue> plannedRevenues;
//
//    @OneToMany
//    private List<PlannedExpenditure> plannedExpenditures;
}
