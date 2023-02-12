package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetChecker;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureQuery;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueQuery;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.budget.BudgetDtoProvider;
import pl.wsikora.successbudget.v3.common.budget.BudgetId;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;
import pl.wsikora.successbudget.v3.common.util.ui.validation.PaginationValidator;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.fillPath;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.formAttributeNameCamelCase;


@Service
class BudgetViewControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final PlannedExpenditureQuery plannedExpenditureQuery;
    private final PlannedRevenueQuery plannedRevenueQuery;
    private final BudgetDtoProvider budgetDtoProvider;
    private final BudgetChecker budgetChecker;

    private BudgetViewControllerDataProvider(MessageProvider messageProvider,
                                             PlannedExpenditureQuery plannedExpenditureQuery,
                                             PlannedRevenueQuery plannedRevenueQuery,
                                             BudgetDtoProvider budgetDtoProvider,
                                             BudgetChecker budgetChecker) {

        this.messageProvider = messageProvider;
        this.plannedExpenditureQuery = plannedExpenditureQuery;
        this.plannedRevenueQuery = plannedRevenueQuery;
        this.budgetDtoProvider = budgetDtoProvider;
        this.budgetChecker = budgetChecker;
    }

    ModelMap provideData(BudgetViewParameters parameters) {

        Assert.notNull(parameters, "parameters must not be null");

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        Long budgetId = parameters.budgetId();

        if (budgetChecker.hasNoBudget(budgetId)) {

            addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

            addAttributePagePathNoResource(modelMap);

            return modelMap;
        }

        addAttributePagePathFromListView(modelMap, BUDGET);

        String title = messageProvider.getMessage(BUDGET_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard()
            .add(title)
            .build());

        modelMap.addAttribute("dto", budgetDtoProvider.provideBudgetDto(BudgetId.of(budgetId)));

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_EXPENDITURE, ADD_URL),
            fillPath(PLANNED_EXPENDITURE_EDIT_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        Integer plannedExpenditurePage = parameters.plannedExpenditurePage();

        Integer plannedExpenditureSize = parameters.plannedExpenditureSize();

        if (PaginationValidator.isValid(plannedExpenditurePage, plannedExpenditureSize)) {

            Pageable pageable = PageRequest.of(plannedExpenditurePage, plannedExpenditureSize);

            modelMap.addAttribute("plannedExpendituresCurrentPage", pageable.getPageNumber());

            modelMap.addAttribute("plannedExpenditures", plannedExpenditureQuery
                .findAll(pageable, budgetId));
        }

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_REVENUE, ADD_URL),
            fillPath(PLANNED_REVENUE_EDIT_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        Integer plannedRevenuePage = parameters.plannedRevenuePage();

        Integer plannedRevenueSize = parameters.plannedRevenueSize();

        if (PaginationValidator.isValid(plannedRevenuePage, plannedRevenueSize)) {

            Pageable pageable = PageRequest.of(plannedRevenuePage, plannedRevenueSize);

            modelMap.addAttribute("plannedRevenuesCurrentPage", pageable.getPageNumber());

            modelMap.addAttribute("plannedRevenues", plannedRevenueQuery
                .findAll(pageable, budgetId));
        }

        return modelMap;
    }

}
