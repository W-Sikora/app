package pl.wsikora.successbudget.v3.common.dashboard;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;


@Embeddable
@NoArgsConstructor
@Getter
public class DashboardId {

    @Column(name = "dashboard_Id")
    private Long value;

    private DashboardId(Long value) {

        this.value = value;
    }

    public static DashboardId of(Long value) {

        Assert.notNull(value, "DashboardId value must not be null");

        return new DashboardId(value);
    }

}
