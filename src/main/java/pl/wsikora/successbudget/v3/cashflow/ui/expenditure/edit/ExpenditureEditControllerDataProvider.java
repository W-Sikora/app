package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import java.util.List;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormViewName;


@Service
class ExpenditureEditControllerDataProvider {

    private final MessageProvider messageProvider;
    private final ExpenditureFormFactory expenditureFormFactory;

    private ExpenditureEditControllerDataProvider(MessageProvider messageProvider,
                                                  ExpenditureFormFactory expenditureFormFactory) {

        this.messageProvider = messageProvider;
        this.expenditureFormFactory = expenditureFormFactory;
    }

    ModelMap provideData(Long cashFlowId, Long expenditureId) {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(PAGE_PATH, getEditFormViewName(EXPENDITURE));

        modelMap.addAttribute(FORM_ACTION, EXPENDITURE_EDIT_PATH);

        ExpenditureForm expenditureForm = expenditureFormFactory.getExpenditureForm(cashFlowId, expenditureId);

        modelMap.addAttribute(FORM, expenditureForm);

        String title = isNull(expenditureForm.getExpenditureId())
            ? messageProvider.getMessage(EXPENDITURE_ADD_TITLE)
            : messageProvider.getMessage(EXPENDITURE_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard()
            .add(messageProvider.getMessage(EXPENDITURE_LIST_TITLE), EXPENDITURE_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        return modelMap;
    }

}
