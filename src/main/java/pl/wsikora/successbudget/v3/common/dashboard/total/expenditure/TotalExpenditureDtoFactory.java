package pl.wsikora.successbudget.v3.common.dashboard.total.expenditure;

public class TotalExpenditureDtoFactory {

    public TotalExpenditureDtoFactory() {}

    public TotalExpenditureDto create(TotalExpenditure totalExpenditure) {

        return new TotalExpenditureDto(
            totalExpenditure.getPlanned().getFormattedValue(),
            totalExpenditure.getCurrent().getFormattedValue()
        );
    }

}
