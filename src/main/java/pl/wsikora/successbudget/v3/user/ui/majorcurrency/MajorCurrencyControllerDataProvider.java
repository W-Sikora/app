package pl.wsikora.successbudget.v3.user.ui.majorcurrency;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.SessionUtils.getPeriod;


@Service
class MajorCurrencyControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final MajorCurrencyFormFactory majorCurrencyFormFactory;

    private MajorCurrencyControllerDataProvider(
        MessageProvider messageProvider,
        MajorCurrencyFormFactory majorCurrencyFormFactory
    ) {

        this.messageProvider = messageProvider;
        this.majorCurrencyFormFactory = majorCurrencyFormFactory;
    }

    ModelMap provideData(HttpSession session) {

        Assert.notNull(session, "session must not be null");

        YearMonth period = getPeriod(session);

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlLandingPagePath(modelMap);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        addAttributePagePathFromForm(modelMap, MAJOR_CURRENCY);

        addAttributeFormAction(modelMap, MAJOR_CURRENCY_EDIT_PATH);

        modelMap.addAttribute("majorCurrencyForm", majorCurrencyFormFactory.getMajorCurrencyForm());

        String title = messageProvider.getMessage("major.currency.page.title");

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard(period)
            .add(title)
            .build());

        modelMap.addAttribute("currencies", Currency.getOrdinals());

        return modelMap;
    }

}
