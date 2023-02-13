package pl.wsikora.successbudget.v3.common.dashboard;

import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.util.databaseconverter.YearMonthDatabaseConverter;

import java.time.YearMonth;


@Embeddable
@NoArgsConstructor
@Getter
public class DashboardDetails {

    private Long dashboardId;

    @Convert(converter = YearMonthDatabaseConverter.class)
    private YearMonth period;

    private DashboardDetails(Long dashboardId, YearMonth period) {

        this.dashboardId = dashboardId;
        this.period = period;
    }

    public static DashboardDetails of(Long value, YearMonth period) {

        Assert.notNull(value, "dashboardId must not be null");
        Assert.notNull(period, "period value must not be null");

        return new DashboardDetails(value, period);
    }

}
