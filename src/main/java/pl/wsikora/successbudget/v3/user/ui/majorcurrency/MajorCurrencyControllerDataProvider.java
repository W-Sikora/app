package pl.wsikora.successbudget.v3.user.ui.majorcurrency;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;


@Service
class MajorCurrencyControllerDataProvider {

    private final MessageProvider messageProvider;
    private final MajorCurrencyFormFactory majorCurrencyFormFactory;

    private MajorCurrencyControllerDataProvider(MessageProvider messageProvider,
                                                MajorCurrencyFormFactory majorCurrencyFormFactory) {

        this.messageProvider = messageProvider;
        this.majorCurrencyFormFactory = majorCurrencyFormFactory;
    }

    ModelMap provideData() {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(COLUMN_SIZE, FORM_PAGE_SIZE);

        modelMap.addAttribute(PAGE_PATH, getEditFormName("major-currency"));

        modelMap.addAttribute(FORM_ACTION, MAJOR_CURRENCY_EDIT_PATH);

        modelMap.addAttribute("majorCurrencyForm", majorCurrencyFormFactory.getMajorCurrencyForm());

        String title = messageProvider.getMessage("major.currency.page.title");

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute("currencies", Currency.getOrdinals());

        return modelMap;
    }

}
