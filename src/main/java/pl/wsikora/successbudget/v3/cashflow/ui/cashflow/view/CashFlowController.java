package pl.wsikora.successbudget.v3.cashflow.ui.cashflow.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static pl.wsikora.successbudget.v3.common.Constants.CASH_FLOW_PATH;
import static pl.wsikora.successbudget.v3.common.Constants.VIEW;


@Controller
@RequestMapping(CASH_FLOW_PATH)
class CashFlowController {

    private final CashFlowControllerDataProvider cashFlowControllerDataProvider;

    private CashFlowController(CashFlowControllerDataProvider cashFlowControllerDataProvider) {

        this.cashFlowControllerDataProvider = cashFlowControllerDataProvider;
    }

    @GetMapping
    private String goToView() {

        return VIEW;
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) String period, Model model) {

        model.addAllAttributes(cashFlowControllerDataProvider.provideData(period));
    }

}
