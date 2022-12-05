package pl.wsikora.successbudget.budget.application.command;

import java.util.List;

public interface BudgetFormAttribute {

    Long getId();

    String getName();

    Long getCreatorId();

    List<Long> getOwnersId();
}
