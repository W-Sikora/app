package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetChecker;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.title.TitleProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.fillPath;


@Service
class PlannedRevenueEditControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final BudgetChecker budgetChecker;
    private final PlannedRevenueFormFactory plannedRevenueFormFactory;
    private final TitleProvider titleProvider;
    private final CategoryDtoProvider categoryDtoProvider;

    private PlannedRevenueEditControllerDataProvider(MessageProvider messageProvider,
                                                     BudgetChecker budgetChecker,
                                                     PlannedRevenueFormFactory plannedRevenueFormFactory,
                                                     CategoryDtoProvider categoryDtoProvider) {

        this.messageProvider = messageProvider;
        this.budgetChecker = budgetChecker;
        this.plannedRevenueFormFactory = plannedRevenueFormFactory;
        this.titleProvider = new TitleProvider(messageProvider);
        this.categoryDtoProvider = categoryDtoProvider;
    }

    ModelMap provideData(PlannedRevenueEditCommand editCommand) {

        Assert.notNull(editCommand, "editCommand must not be null");

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        if (budgetChecker.hasNoBudget(editCommand.budgetId())) {

            addAttributePagePathNoResource(modelMap);

            return modelMap;
        }

        addAttributePagePathFromForm(modelMap, PLANNED_REVENUE);

        addAttributeFormAction(modelMap, PLANNED_REVENUE_ADD_PATH, BUDGET_ID_PATH_VARIABLE,
            editCommand.budgetId());

        modelMap.addAttribute("plannedRevenueForm", plannedRevenueFormFactory
            .getPlannedExpenditureForm(editCommand));

        String title = titleProvider.provideTitle(editCommand.plannedRevenueId(),
            PLANNED_REVENUE_ADD_TITLE, PLANNED_REVENUE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard()
            .add(BUDGET, fillPath(BUDGET_PATH, ID_PATH_VARIABLE, editCommand.budgetId()))
            .add(title)
            .build());

        modelMap.addAttribute("categories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.REVENUE));

        modelMap.addAttribute("currencies", Currency.values());

        return modelMap;
    }

}
