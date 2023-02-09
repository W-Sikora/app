package pl.wsikora.successbudget.v3.objective.application;

public interface ObjectiveCommand {

    void save(ObjectiveAttributes objectiveAttributes);

    void realized(Long objectiveId);

}
