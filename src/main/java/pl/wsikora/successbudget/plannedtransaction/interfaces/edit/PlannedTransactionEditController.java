package pl.wsikora.successbudget.plannedtransaction.interfaces.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractEditController;
import pl.wsikora.successbudget.plannedtransaction.application.command.PlannedTransactionCommandService;

import java.time.YearMonth;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.plannedtransaction.interfaces.PlannedTransactionConstant.PLANNED_TRANSACTION_EDIT_URL;
import static pl.wsikora.successbudget.plannedtransaction.interfaces.PlannedTransactionConstant.PLANNED_TRANSACTION_EDIT_VIEW;

@Controller
@RequestMapping(PLANNED_TRANSACTION_EDIT_URL)
class PlannedTransactionEditController extends AbstractEditController<PlannedTransactionForm> {

    private final PlannedTransactionCommandService plannedTransactionCommandService;
    private final PlannedTransactionFormFactory plannedTransactionFormFactory;
    private final PlannedTransactionFormValidator plannedTransactionFormValidator;

    private PlannedTransactionEditController(PlannedTransactionCommandService plannedTransactionCommandService,
                                             PlannedTransactionFormFactory plannedTransactionFormFactory,
                                             PlannedTransactionFormValidator plannedTransactionFormValidator) {

        this.plannedTransactionCommandService = plannedTransactionCommandService;
        this.plannedTransactionFormFactory = plannedTransactionFormFactory;
        this.plannedTransactionFormValidator = plannedTransactionFormValidator;
    }

    @Override
    protected String goToView() {

        return PLANNED_TRANSACTION_EDIT_VIEW;
    }

    @Override
    protected String save(PlannedTransactionForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return PLANNED_TRANSACTION_EDIT_VIEW;
        }

        plannedTransactionCommandService.save(form);

        return redirect("");
    }

    @Override
    protected void initData(Long id, ModelMap modelMap) {

        modelMap.addAttribute("plannedTransactionForm", plannedTransactionFormFactory.getForm(id))
                .addAttribute("action", PLANNED_TRANSACTION_EDIT_URL);

        if (isNull(id)) {

            modelMap.addAttribute("accountingPeriod", YearMonth.now().toString());
        }
    }

    @Override
    protected void initBinder(WebDataBinder binder) {

        binder.setValidator(plannedTransactionFormValidator);
    }
}
