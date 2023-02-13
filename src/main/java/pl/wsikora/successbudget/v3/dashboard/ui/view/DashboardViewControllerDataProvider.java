package pl.wsikora.successbudget.v3.dashboard.ui.view;

import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.cashflow.UnnecessaryExpenditureProvider;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;
import pl.wsikora.successbudget.v3.common.util.ui.validation.PaginationValidator;
import pl.wsikora.successbudget.v3.dashboard.application.TotalDtoFactory;

import java.time.YearMonth;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.PathUtils.pathWithPeriod;


@Service
class DashboardViewControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final TotalDtoFactory totalDtoFactory;
    private final UnnecessaryExpenditureProvider unnecessaryExpenditureProvider;

    private DashboardViewControllerDataProvider(
        MessageProvider messageProvider,
        TotalDtoFactory totalDtoFactory,
        UnnecessaryExpenditureProvider unnecessaryExpenditureProvider
    ) {

        this.messageProvider = messageProvider;
        this.totalDtoFactory = totalDtoFactory;
        this.unnecessaryExpenditureProvider = unnecessaryExpenditureProvider;
    }

    ModelMap provideData(DashboardViewParameters parameters, HttpSession session) {

        Assert.notNull(session, "session must not be null");

        YearMonth period = parameters.period();

        if (isNull(period)) {

            period = YearMonth.now();
        }

        session.setAttribute(PERIOD, period);

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        String title = messageProvider.getMessage(DASHBOARD_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute("objectiveUrl", OBJECTIVE_PATH);

        modelMap.addAttribute("categoryUrl", CATEGORY_PATH);

        modelMap.addAttribute("budgetUrl", pathWithPeriod(BUDGET_PATH, period));

        modelMap.addAttribute("cashFlowUrl", pathWithPeriod(CASH_FLOW_PATH, period));

        modelMap.addAttribute("totalDto", totalDtoFactory.create(period));

        Integer page = parameters.page();

        Integer size = parameters.size();

        if (PaginationValidator.isValid(page, size)) {

            Pageable pageable = PageRequest.of(page, size);

            modelMap.addAttribute("unnecessaryExpendituresCurrentPage", pageable.getPageNumber());

            modelMap.addAttribute("unnecessaryExpenditures", unnecessaryExpenditureProvider
                .findAllUnnecessaryExpenditures(pageable, period));
        }

        return modelMap;
    }

}
