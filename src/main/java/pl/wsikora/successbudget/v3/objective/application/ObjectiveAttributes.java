package pl.wsikora.successbudget.v3.objective.application;

import java.math.BigDecimal;


public interface ObjectiveAttributes {

    Long getObjectiveId();

    String getTitle();

    String getDescription();

    Long getNecessaryMoneyCurrency();

    BigDecimal getNecessaryMoney();

    Long getRaisedMoneyCurrency();

    BigDecimal getRaisedMoney();

}
