package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetFilter;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureQuery;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueQuery;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.budget.BudgetDtoProvider;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;
import pl.wsikora.successbudget.v3.common.util.ui.validation.PaginationValidator;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.formAttributeNameCamelCase;


@Service
class BudgetViewControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final PlannedExpenditureQuery plannedExpenditureQuery;
    private final PlannedRevenueQuery plannedRevenueQuery;
    private final BudgetDtoProvider budgetDtoProvider;
    private final CategoryDtoProvider categoryDtoProvider;

    private BudgetViewControllerDataProvider(
        MessageProvider messageProvider,
        PlannedExpenditureQuery plannedExpenditureQuery,
        PlannedRevenueQuery plannedRevenueQuery,
        BudgetDtoProvider budgetDtoProvider,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.messageProvider = messageProvider;
        this.plannedExpenditureQuery = plannedExpenditureQuery;
        this.plannedRevenueQuery = plannedRevenueQuery;
        this.budgetDtoProvider = budgetDtoProvider;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    ModelMap provideData(BudgetViewParameters parameters) {

        Assert.notNull(parameters, "parameters must not be null");

        YearMonth period = parameters.period();

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributePagePathFromListView(modelMap, BUDGET);

        String title = messageProvider.getMessage(BUDGET_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard(period)
            .add(title)
            .build());

        modelMap.addAttribute("dto", budgetDtoProvider.provideBudgetDto(period));

        modelMap.addAttribute("plannedExpenditureCategories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.EXPENDITURE));

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_EXPENDITURE, ADD_URL),
            PLANNED_EXPENDITURE_ADD_PATH);

        Integer plannedExpenditurePage = parameters.plannedExpenditurePage();

        Integer plannedExpenditureSize = parameters.plannedExpenditureSize();

        if (PaginationValidator.isValid(plannedExpenditurePage, plannedExpenditureSize)) {

            Pageable pageable = PageRequest.of(plannedExpenditurePage, plannedExpenditureSize);

            modelMap.addAttribute("plannedExpendituresCurrentPage", pageable.getPageNumber());

            BudgetFilter budgetFilter = new BudgetFilter(pageable, period,
                parameters.plannedExpenditureCategoryId());

            modelMap.addAttribute("plannedExpenditures", plannedExpenditureQuery
                .findAll(budgetFilter));
        }

        modelMap.addAttribute("plannedRevenueCategories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.REVENUE));

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_REVENUE, ADD_URL),
            PLANNED_REVENUE_ADD_PATH);

        Integer plannedRevenuePage = parameters.plannedRevenuePage();

        Integer plannedRevenueSize = parameters.plannedRevenueSize();

        if (PaginationValidator.isValid(plannedRevenuePage, plannedRevenueSize)) {

            Pageable pageable = PageRequest.of(plannedRevenuePage, plannedRevenueSize);

            modelMap.addAttribute("plannedRevenuesCurrentPage", pageable.getPageNumber());

            BudgetFilter budgetFilter = new BudgetFilter(pageable, period,
                parameters.plannedRevenueCategoryId());

            modelMap.addAttribute("plannedRevenues", plannedRevenueQuery
                .findAll(budgetFilter));
        }

        return modelMap;
    }

}
