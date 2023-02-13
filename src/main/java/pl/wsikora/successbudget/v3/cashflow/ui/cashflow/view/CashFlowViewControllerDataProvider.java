package pl.wsikora.successbudget.v3.cashflow.ui.cashflow.view;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;
import pl.wsikora.successbudget.v3.common.util.ui.validation.PaginationValidator;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.formAttributeNameCamelCase;


@Service
class CashFlowViewControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final CategoryDtoProvider categoryDtoProvider;

    private CashFlowViewControllerDataProvider(
        MessageProvider messageProvider,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.messageProvider = messageProvider;
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

//        modelMap.addAttribute("dto", budgetDtoProvider.provideBudgetDto(period));

        modelMap.addAttribute("expenditureCategories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.EXPENDITURE));

        modelMap.addAttribute(formAttributeNameCamelCase(EXPENDITURE, ADD_URL),
            EXPENDITURE_ADD_PATH);

        Integer expenditurePage = parameters.expenditurePage();

        Integer expenditureSize = parameters.expenditureSize();

        if (PaginationValidator.isValid(expenditurePage, expenditureSize)) {

            Pageable pageable = PageRequest.of(expenditurePage, expenditureSize);

            modelMap.addAttribute("expendituresCurrentPage", pageable.getPageNumber());

//            CashFlowFilter cashFlowFilter = new CashFlowFilter()
//            BudgetFilter budgetFilter = new BudgetFilter(pageable, period,
//                parameters.expenditureCategoryId());
//
//            modelMap.addAttribute("plannedExpenditures", plannedExpenditureQuery
//                .findAll(budgetFilter));
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

//            BudgetFilter budgetFilter = new BudgetFilter(pageable, period,
//                parameters.revenueCategoryId());
//
//            modelMap.addAttribute("plannedRevenues", plannedRevenueQuery
//                .findAll(budgetFilter));
        }

        return modelMap;
    }

}
