package pl.wsikora.successbudget.v3.cashflow.ui.cashflow.view;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.cashflow.CashFlowDtoProvider;
import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowFilter;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureQuery;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueQuery;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;
import pl.wsikora.successbudget.v3.common.util.ui.validation.PaginationValidator;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.formAttributeNameCamelCase;


@Service
class CashFlowViewControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final CashFlowDtoProvider cashFlowDtoProvider;
    private final ExpenditureQuery expenditureQuery;
    private final RevenueQuery revenueQuery;
    private final CategoryDtoProvider categoryDtoProvider;

    private CashFlowViewControllerDataProvider(
        MessageProvider messageProvider,
        CashFlowDtoProvider cashFlowDtoProvider,
        ExpenditureQuery expenditureQuery,
        RevenueQuery revenueQuery,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.messageProvider = messageProvider;
        this.cashFlowDtoProvider = cashFlowDtoProvider;
        this.expenditureQuery = expenditureQuery;
        this.revenueQuery = revenueQuery;
        this.categoryDtoProvider = categoryDtoProvider;
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

        modelMap.addAttribute("dto", cashFlowDtoProvider.provideCashFlowDto(period));

        modelMap.addAttribute("additionalTitle", period.format(PERIOD_FORMATTER));

        modelMap.addAttribute("expenditureCategories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.EXPENDITURE));

        modelMap.addAttribute(formAttributeNameCamelCase(EXPENDITURE, ADD_URL),
            EXPENDITURE_ADD_PATH);

        Integer expenditurePage = parameters.expenditurePage();

        Integer expenditureSize = parameters.expenditureSize();

        if (PaginationValidator.isValid(expenditurePage, expenditureSize)) {

            Pageable pageable = PageRequest.of(expenditurePage, expenditureSize);

            modelMap.addAttribute("expendituresCurrentPage", pageable.getPageNumber());

            CashFlowFilter cashFlowFilter = new CashFlowFilter(pageable, period,
                null, null, null, null, null);

            modelMap.addAttribute("expenditures", expenditureQuery.findAll(cashFlowFilter));
        }

        modelMap.addAttribute("plannedRevenueCategories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.REVENUE));

        modelMap.addAttribute(formAttributeNameCamelCase(REVENUE, ADD_URL),
            REVENUE_ADD_PATH);

        Integer plannedRevenuePage = parameters.revenuePage();

        Integer plannedRevenueSize = parameters.revenueSize();

        if (PaginationValidator.isValid(plannedRevenuePage, plannedRevenueSize)) {

            Pageable pageable = PageRequest.of(plannedRevenuePage, plannedRevenueSize);

            modelMap.addAttribute("revenuesCurrentPage", pageable.getPageNumber());

            CashFlowFilter cashFlowFilter = new CashFlowFilter(pageable, period,
                null, null, null, null, null);

            modelMap.addAttribute("revenues", revenueQuery.findAll(cashFlowFilter));
        }

        return modelMap;
    }

}
