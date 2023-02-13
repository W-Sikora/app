package pl.wsikora.successbudget.v3.common.dashboard.total.revenue;

public class TotalRevenueDtoFactory {

    public TotalRevenueDtoFactory() {}

    public TotalRevenueDto create(TotalRevenue totalRevenue) {

        return new TotalRevenueDto(
            totalRevenue.getPlanned().getFormattedValue(),
            totalRevenue.getCurrent().getFormattedValue()
        );
    }

}
