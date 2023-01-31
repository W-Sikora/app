package pl.wsikora.successbudget.v3.common.type;

public enum Schedule {

    DAILY("0 0 0 ? * * *"),
    ONCE_A_WEEK("0 0 0 1/7 * ? *"),
    ONCE_A_MONTH("0 0 0 ? * * *");

    private final String cronExpressions;

    Schedule(String cronExpressions) {

        this.cronExpressions = cronExpressions;
    }

    public String getCronExpressions() {

        return cronExpressions;
    }
}
