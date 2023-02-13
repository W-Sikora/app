package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import java.time.YearMonth;
import java.util.List;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.SessionUtils.getPeriod;


@Service
class RevenueEditControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final RevenueFormFactory revenueFormFactory;

    private RevenueEditControllerDataProvider(
        MessageProvider messageProvider,
        RevenueFormFactory revenueFormFactory
    ) {

        this.messageProvider = messageProvider;
        this.revenueFormFactory = revenueFormFactory;
    }

    ModelMap provideData(@Nullable Long expenditureId, HttpSession session) {

        Assert.notNull(session, "session must not be null");

        YearMonth period = getPeriod(session);

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        modelMap.addAttribute(FORM_ACTION, EXPENDITURE_EDIT_PATH);

        RevenueForm revenueForm = revenueFormFactory.getRevenueForm(expenditureId, period);

        modelMap.addAttribute(FORM, revenueForm);

        String title = isNull(revenueForm.getRevenueId())
            ? messageProvider.getMessage(EXPENDITURE_ADD_TITLE)
            : messageProvider.getMessage(EXPENDITURE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard(period)
            .addWithPeriod(CASH_FLOW_TITLE, CASH_FLOW_PATH, period)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        return modelMap;
    }

}
