package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.cashflow.application.expenditure.ExpenditureCommand;

import javax.validation.Valid;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(EXPENDITURE_EDIT_PATH)
class ExpenditureEditController {

    private final ExpenditureCommand expenditureCommand;
    private final ExpenditureFormValidator expenditureFormValidator;
    private final ExpenditureEditControllerDataProvider expenditureEditControllerDataProvider;

    private ExpenditureEditController(ExpenditureCommand expenditureCommand,
                                      ExpenditureFormValidator expenditureFormValidator,
                                      ExpenditureEditControllerDataProvider expenditureEditControllerDataProvider) {

        this.expenditureCommand = expenditureCommand;
        this.expenditureFormValidator = expenditureFormValidator;
        this.expenditureEditControllerDataProvider = expenditureEditControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute ExpenditureForm expenditureForm,
                        BindingResult bindingResult,
                        @PathVariable Long cashFlowId) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        expenditureCommand.save(expenditureForm);

        return redirect(CASH_FLOW_PATH, cashFlowId);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(expenditureFormValidator);
    }

    @ModelAttribute
    private void data(@PathVariable Long cashFlowId,
                      @RequestParam(required = false) Long id,
                      Model model) {

        model.addAllAttributes(expenditureEditControllerDataProvider.provideData(cashFlowId, id));
    }

}
