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
import static pl.wsikora.successbudget.v3.common.util.StringUtils.fillPath;


@Service
class PlannedRevenueEditControllerDataProvider {

    private final MessageProvider messageProvider;
    private final PlannedRevenueFormFactory plannedRevenueFormFactory;
    private final CategoryDtoProvider categoryDtoProvider;

    private PlannedRevenueEditControllerDataProvider(MessageProvider messageProvider,
                                                     PlannedRevenueFormFactory plannedRevenueFormFactory,
                                                     CategoryDtoProvider categoryDtoProvider) {

        this.messageProvider = messageProvider;
        this.plannedRevenueFormFactory = plannedRevenueFormFactory;
        this.categoryDtoProvider = categoryDtoProvider;
    }

    ModelMap provideData(Long budgetId, @Nullable Long plannedExpenditureId) {

        Assert.notNull(budgetId, "budgetId must not be null");

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(COLUMN_SIZE, FORM_PAGE_SIZE);

        modelMap.addAttribute(PAGE_PATH, getEditFormName(PLANNED_REVENUE));

        modelMap.addAttribute(FORM_ACTION, fillPath(PLANNED_REVENUE_EDIT_PATH, BUDGET_ID_PATH_VARIABLE, budgetId));

        PlannedRevenueForm plannedRevenueForm = plannedRevenueFormFactory.getPlannedExpenditureForm(
            budgetId, plannedExpenditureId);

        modelMap.addAttribute("plannedRevenueForm", plannedRevenueForm);

        String title = isNull(plannedRevenueForm.getCategoryId())
            ? messageProvider.getMessage(PLANNED_REVENUE_ADD_TITLE)
            : messageProvider.getMessage(PLANNED_REVENUE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(messageProvider.getMessage(BUDGET), fillPath(BUDGET_PATH, ID_PATH_VARIABLE, budgetId))
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute("categories", categoryDtoProvider.provideAllByAssignedTransactionType(
            TransactionType.REVENUE));

        modelMap.addAttribute("currencies", Currency.values());

        return modelMap;
    }

}
