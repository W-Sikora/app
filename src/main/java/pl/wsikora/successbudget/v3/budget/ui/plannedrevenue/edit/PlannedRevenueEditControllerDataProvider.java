package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import java.util.List;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;


@Service
class PlannedRevenueEditControllerDataProvider {

    private final MessageProvider messageProvider;
    private final PlannedRevenueFormFactory plannedExpenditureFormFactory;
    private final CategoryDtoProvider categoryDtoProvider;

    private PlannedRevenueEditControllerDataProvider(MessageProvider messageProvider,
                                                     PlannedRevenueFormFactory plannedExpenditureFormFactory,
                                                     CategoryDtoProvider categoryDtoProvider) {

        this.messageProvider = messageProvider;
        this.plannedExpenditureFormFactory = plannedExpenditureFormFactory;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    ModelMap provideData(Long budgetId, @Nullable Long plannedExpenditureId) {

        Assert.notNull(budgetId, "budgetId must not be null");

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(PAGE_PATH, getEditFormName(PLANNED_EXPENDITURE));

        modelMap.addAttribute(FORM_ACTION, PLANNED_EXPENDITURE_EDIT_PATH);

        PlannedRevenueForm plannedRevenueForm = plannedExpenditureFormFactory.getPlannedExpenditureForm(
            budgetId, plannedExpenditureId);

        modelMap.addAttribute("plannedRevenueForm", plannedRevenueForm);

        String title = isNull(plannedRevenueForm.getCategoryId())
            ? messageProvider.getMessage(PLANNED_EXPENDITURE_ADD_TITLE)
            : messageProvider.getMessage(PLANNED_EXPENDITURE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(messageProvider.getMessage(BUDGET), BUDGET_PATH + ID_PATH_QUERY + budgetId)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute("categories", categoryDtoProvider.provideAllByAssignedTransactionType(
            TransactionType.REVENUE));

        modelMap.addAttribute("currencies", Currency.getOrdinals());

        return modelMap;
    }

}
