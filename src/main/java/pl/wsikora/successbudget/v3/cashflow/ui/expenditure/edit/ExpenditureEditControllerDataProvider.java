package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpSession;
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
class ExpenditureEditControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final ExpenditureFormFactory expenditureFormFactory;
    private final TitleProvider titleProvider;
    private final CategoryDtoProvider categoryDtoProvider;

    private ExpenditureEditControllerDataProvider(
        MessageProvider messageProvider,
        ExpenditureFormFactory expenditureFormFactory,
        CategoryDtoProvider categoryDtoProvider
    ) {

        this.messageProvider = messageProvider;
        this.expenditureFormFactory = expenditureFormFactory;
        this.titleProvider = new TitleProvider(messageProvider);
        this.categoryDtoProvider = categoryDtoProvider;
    }

    ModelMap provideData(@Nullable Long expenditureId, HttpSession session) {

        Assert.notNull(session, "session must not be null");

        YearMonth period = getPeriod(session);

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        addAttributePagePathFromForm(modelMap, EXPENDITURE);

        addAttributeFormAction(modelMap, EXPENDITURE_ADD_PATH);

        ExpenditureForm expenditureForm = expenditureFormFactory
            .getExpenditureForm(expenditureId, period);

        modelMap.addAttribute("expenditureForm", expenditureForm);

        String title = titleProvider.provideTitle(expenditureForm.getExpenditureId(),
            EXPENDITURE_ADD_TITLE, EXPENDITURE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard(period)
            .addWithPeriod(CASH_FLOW_TITLE, CASH_FLOW_PATH, period)
            .add(title)
            .build());

        modelMap.addAttribute("categories", categoryDtoProvider
            .provideAllByAssignedTransactionType(TransactionType.EXPENDITURE));

        modelMap.addAttribute("priorities", Priority.getOrdinals());

        modelMap.addAttribute("currencies", Currency.values());

        modelMap.addAttribute("minDate", period.atDay(1));

        modelMap.addAttribute("maxDate", period.atEndOfMonth());

        return modelMap;
    }

}
