package pl.wsikora.successbudget.v3.objective.application;

import pl.wsikora.successbudget.v3.common.type.Username;


public interface ObjectiveCommand {

    void save(ObjectiveAttributes objectiveAttributes, Username username);

    void setRealized(Long objectiveId);

}
