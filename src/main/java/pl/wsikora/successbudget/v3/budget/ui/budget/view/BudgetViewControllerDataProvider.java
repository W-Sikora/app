package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureQuery;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueQuery;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.validation.PaginationValidator;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getListName;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.fillPath;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.formAttributeNameCamelCase;


@Service
class BudgetViewControllerDataProvider {

    private final MessageProvider messageProvider;
    private final PlannedExpenditureQuery plannedExpenditureQuery;
    private final PlannedRevenueQuery plannedRevenueQuery;

    private BudgetViewControllerDataProvider(MessageProvider messageProvider,
                                             PlannedExpenditureQuery plannedExpenditureQuery,
                                             PlannedRevenueQuery plannedRevenueQuery) {

        this.messageProvider = messageProvider;
        this.plannedExpenditureQuery = plannedExpenditureQuery;
        this.plannedRevenueQuery = plannedRevenueQuery;
    }

    ModelMap provideData(Long budgetId,
                         int plannedExpenditurePage,
                         int plannedExpenditureSize,
                         int plannedRevenuePage,
                         int plannedRevenueSize) {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(PAGE_PATH, getListName(BUDGET));

        modelMap.addAttribute(COLUMN_SIZE, "is-12");

        String title = messageProvider.getMessage(BUDGET_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_EXPENDITURE, ADD_URL),
            fillPath(PLANNED_EXPENDITURE_EDIT_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_EXPENDITURE, EDIT_URL),
            fillPath(PLANNED_EXPENDITURE_EDIT_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_EXPENDITURE, DELETE_URL),
            fillPath(PLANNED_EXPENDITURE_DELETE_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        if (PaginationValidator.isValid(plannedExpenditurePage, plannedExpenditureSize)) {

            Pageable pageable = PageRequest.of(plannedExpenditurePage, plannedExpenditureSize);

            modelMap.addAttribute(CURRENT_PAGE, pageable.getPageNumber() + 1);

            modelMap.addAttribute("plannedExpenditures",
                plannedExpenditureQuery.findAll(pageable, budgetId));
        }

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_REVENUE, ADD_URL),
            fillPath(PLANNED_REVENUE_EDIT_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_REVENUE, EDIT_URL),
            fillPath(PLANNED_REVENUE_EDIT_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        modelMap.addAttribute(formAttributeNameCamelCase(PLANNED_REVENUE, DELETE_URL),
            fillPath(PLANNED_REVENUE_DELETE_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        if (PaginationValidator.isValid(plannedRevenuePage, plannedRevenueSize)) {

            Pageable pageable = PageRequest.of(plannedRevenuePage, plannedRevenueSize);

            modelMap.addAttribute(CURRENT_PAGE, pageable.getPageNumber() + 1);

            modelMap.addAttribute("plannedRevenues",
                plannedRevenueQuery.findAll(pageable, budgetId));
        }

        return modelMap;
    }

}
