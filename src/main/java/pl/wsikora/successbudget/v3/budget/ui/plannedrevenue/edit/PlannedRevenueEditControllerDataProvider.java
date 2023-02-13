package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import jakarta.servlet.http.HttpSession;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.title.TitleProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.SessionUtils.getPeriod;


@Service
class PlannedRevenueEditControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final PlannedRevenueFormFactory plannedRevenueFormFactory;
    private final TitleProvider titleProvider;
    private final CategoryDtoProvider categoryDtoProvider;

    private PlannedRevenueEditControllerDataProvider(
        MessageProvider messageProvider,
        PlannedRevenueFormFactory plannedRevenueFormFactory,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.messageProvider = messageProvider;
        this.plannedRevenueFormFactory = plannedRevenueFormFactory;
        this.titleProvider = new TitleProvider(messageProvider);
        this.categoryDtoProvider = categoryDtoProvider;
    }

    ModelMap provideData(@Nullable Long plannedRevenueId, HttpSession session) {

        Assert.notNull(session, "session must not be null");

        YearMonth period = getPeriod(session);

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        addAttributePagePathFromForm(modelMap, PLANNED_REVENUE);

        addAttributeFormAction(modelMap, PLANNED_REVENUE_ADD_PATH);

        PlannedRevenueForm plannedExpenditureForm = plannedRevenueFormFactory
            .getPlannedExpenditureForm(plannedRevenueId, period);

        modelMap.addAttribute("plannedRevenueForm", plannedExpenditureForm);

        String title = titleProvider.provideTitle(plannedExpenditureForm.getPlannedRevenueId(),
            PLANNED_REVENUE_ADD_TITLE, PLANNED_REVENUE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard(period)
            .addWithPeriod(BUDGET, BUDGET_PATH, period)
            .add(title)
            .build());

        modelMap.addAttribute("categories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.REVENUE));

        modelMap.addAttribute("currencies", Currency.values());

        return modelMap;
    }

}
