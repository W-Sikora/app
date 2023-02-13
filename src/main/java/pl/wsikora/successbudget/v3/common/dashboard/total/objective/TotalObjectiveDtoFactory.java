package pl.wsikora.successbudget.v3.common.dashboard.total.objective;

public class TotalObjectiveDtoFactory {

    public TotalObjectiveDtoFactory() {}

    public TotalObjectiveDto create(TotalObjective totalObjective) {

        return new TotalObjectiveDto(
            totalObjective.getValue().getFormattedValue()
        );
    }

}
