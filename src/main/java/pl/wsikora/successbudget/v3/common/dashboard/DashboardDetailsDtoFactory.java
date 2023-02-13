package pl.wsikora.successbudget.v3.common.dashboard;

import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;


public class DashboardDetailsDtoFactory {

    private DashboardDetailsDtoFactory() {}

    public static DashboardDetailsDto create(DashboardDetails dashboardDetails) {

        return new DashboardDetailsDto(
            dashboardDetails.getDashboardId(),
            dashboardDetails.getPeriod().format(PERIOD_FORMATTER)
        );
    }

}
