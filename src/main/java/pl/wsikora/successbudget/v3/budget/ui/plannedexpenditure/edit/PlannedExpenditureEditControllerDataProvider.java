package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import jakarta.servlet.http.HttpSession;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.category.CategoryDtoProvider;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.title.TitleProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.SessionUtils.getPeriod;


@Service
class PlannedExpenditureEditControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final PlannedExpenditureFormFactory plannedExpenditureFormFactory;
    private final TitleProvider titleProvider;
    private final CategoryDtoProvider categoryDtoProvider;


    private PlannedExpenditureEditControllerDataProvider(
        MessageProvider messageProvider,
        PlannedExpenditureFormFactory plannedExpenditureFormFactory,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.messageProvider = messageProvider;
        this.plannedExpenditureFormFactory = plannedExpenditureFormFactory;
        this.titleProvider = new TitleProvider(messageProvider);
        this.categoryDtoProvider = categoryDtoProvider;
    }

    ModelMap provideData(@Nullable Long plannedExpenditureId, HttpSession session) {

        Assert.notNull(session, "session must not be null");

        YearMonth period = getPeriod(session);

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        addAttributePagePathFromForm(modelMap, PLANNED_EXPENDITURE);

        addAttributeFormAction(modelMap, PLANNED_EXPENDITURE_ADD_PATH);

        PlannedExpenditureForm plannedExpenditureForm = plannedExpenditureFormFactory
            .createPlannedExpenditureForm(plannedExpenditureId, period);

        modelMap.addAttribute("plannedExpenditureForm", plannedExpenditureForm);

        String title = titleProvider.provideTitle(plannedExpenditureForm.getPlannedExpenditureId(),
            PLANNED_EXPENDITURE_ADD_TITLE, PLANNED_EXPENDITURE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard(period)
            .addWithPeriod(BUDGET, BUDGET_PATH, period)
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
