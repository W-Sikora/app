package pl.wsikora.successbudget.v3.common.type.repeat;

import org.springframework.util.Assert;

import java.time.YearMonth;


public record RepeatCommand(YearMonth fromPeriod, YearMonth toPeriod) {

    public RepeatCommand {

        Assert.notNull(fromPeriod, "fromPeriod must not be null");
        Assert.notNull(toPeriod, "toPeriod must not be null");
    }

}
