package pl.wsikora.successbudget.v3.dashboard.application;

import java.time.YearMonth;


public interface DashboardQuery {

    YearMonth getLast();

    YearMonth getNext();

}
