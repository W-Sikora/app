package pl.wsikora.successbudget.v3.common.dashboard;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.io.Serializable;


@Embeddable
@NoArgsConstructor
@Getter
public class DashboardId implements Serializable {

    @Column(name = "dashboard_id")
    private Long value;

    public DashboardId(Long value) {

        Assert.notNull(value, "DashboardId value must not be null");

        this.value = value;
    }

}
