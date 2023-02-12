package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetChecker;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.title.TitleProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.fillPath;


@Service
class PlannedExpenditureEditControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final BudgetChecker budgetChecker;
    private final PlannedExpenditureFormFactory plannedExpenditureFormFactory;
    private final TitleProvider titleProvider;
    private final CategoryDtoProvider categoryDtoProvider;


    private PlannedExpenditureEditControllerDataProvider(
        MessageProvider messageProvider,
        BudgetChecker budgetChecker,
        PlannedExpenditureFormFactory plannedExpenditureFormFactory,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.messageProvider = messageProvider;
        this.budgetChecker = budgetChecker;
        this.plannedExpenditureFormFactory = plannedExpenditureFormFactory;
        this.titleProvider = new TitleProvider(messageProvider);
        this.categoryDtoProvider = categoryDtoProvider;
    }

    ModelMap provideData(PlannedExpenditureEditCommand editCommand) {

        Assert.notNull(editCommand, "editCommand must not be null");

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        if (budgetChecker.hasNoBudget(editCommand.budgetId())) {

            addAttributePagePathNoResource(modelMap);

            return modelMap;
        }

        addAttributePagePathFromForm(modelMap, PLANNED_EXPENDITURE);

        addAttributeFormAction(modelMap, PLANNED_EXPENDITURE_ADD_PATH, BUDGET_ID_PATH_VARIABLE,
            editCommand.budgetId());

        modelMap.addAttribute("plannedExpenditureForm", plannedExpenditureFormFactory
            .createPlannedExpenditureForm(editCommand));

        String title = titleProvider.provideTitle(editCommand.plannedExpenditureId(),
            PLANNED_EXPENDITURE_ADD_TITLE, PLANNED_EXPENDITURE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard()
            .add(BUDGET, fillPath(BUDGET_PATH, BUDGET_ID_PATH_VARIABLE, editCommand.budgetId()))
            .add(title)
            .build()
        );

        modelMap.addAttribute("categories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.EXPENDITURE));

        modelMap.addAttribute("priorities", Priority.getOrdinals());

        modelMap.addAttribute("currencies", Currency.values());

        return modelMap;
    }

}
