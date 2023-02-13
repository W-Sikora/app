package pl.wsikora.successbudget.v3.cashflow.ui.cashflow.view;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


@Service
class CashFlowViewControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;

    private CashFlowViewControllerDataProvider(MessageProvider messageProvider) {

        this.messageProvider = messageProvider;
    }

    ModelMap provideData(CashFlowViewParameters parameters) {

        Assert.notNull(parameters, "parameters must not be null");

        YearMonth period = parameters.period();

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributePagePathFromListView(modelMap, CASH_FLOW);

        String title = messageProvider.getMessage(CASH_FLOW_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard(period)
            .add(title)
            .build());

        return modelMap;
    }

}
