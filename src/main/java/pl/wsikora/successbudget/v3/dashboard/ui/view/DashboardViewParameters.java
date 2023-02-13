package pl.wsikora.successbudget.v3.dashboard.ui.view;

import org.springframework.lang.Nullable;

import java.time.YearMonth;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_PAGE;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_SIZE;


record DashboardViewParameters(@Nullable YearMonth period,
                               @Nullable Integer page,
                               @Nullable Integer size) {

    DashboardViewParameters(YearMonth period,
                            @Nullable Integer page,
                            @Nullable Integer size) {

        this.period = period;

        this.page = isNull(page) ?
            DEFAULT_PAGINATION_PAGE : page;

        this.size = isNull(size) ?
            DEFAULT_PAGINATION_SIZE : size;
    }

}
