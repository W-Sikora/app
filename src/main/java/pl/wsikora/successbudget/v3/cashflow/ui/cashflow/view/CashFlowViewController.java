package pl.wsikora.successbudget.v3.cashflow.ui.cashflow.view;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.YearMonth;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


@Controller
@RequestMapping(CASH_FLOW_PATH)
class CashFlowViewController {

    private final CashFlowViewControllerDataProvider dataProvider;

    private CashFlowViewController(CashFlowViewControllerDataProvider dataProvider) {

        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view(@RequestParam YearMonth period, HttpSession session) {

        session.setAttribute(PERIOD, period);

        return VIEW;
    }

    @ModelAttribute
    private void data(CashFlowViewParameters parameters, Model model) {

        model.addAllAttributes(dataProvider.provideData(parameters));
    }

}
