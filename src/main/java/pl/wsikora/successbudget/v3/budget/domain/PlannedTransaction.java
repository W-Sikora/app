package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.wsikora.successbudget.v3.common.type.*;
import pl.wsikora.successbudget.v3.user.domain.User;

import java.time.YearMonth;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
abstract class PlannedTransaction {

    @ManyToOne
    @JoinColumn()
    private Budget budget;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @Enumerated
    private CategoryId categoryId;

    @Embedded
    private Money money;

    @ManyToOne
    private User user;

    private boolean cyclical;

    @Embedded
    private Schedule schedule;

    private YearMonth yearMonth;
}
