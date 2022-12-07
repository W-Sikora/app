package pl.wsikora.successbudget.plannedtransaction.interfaces.edit;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractEditController;
import pl.wsikora.successbudget.plannedtransaction.application.command.PlannedTransactionCommandService;

import java.time.YearMonth;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.common.Constants.EDIT_VIEW;
import static pl.wsikora.successbudget.common.Constants.FORM_PAGE;
import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.common.currentuser.application.CurrentUserDtoExtractor.extractCurrentUserDto;
import static pl.wsikora.successbudget.common.interfaces.EditControllerUtils.getEditFormName;
import static pl.wsikora.successbudget.plannedtransaction.interfaces.PlannedTransactionConstant.*;
import static pl.wsikora.successbudget.preference.interfaces.PreferenceConstants.PREFERENCE;


@Controller
@RequestMapping(PLANNED_TRANSACTION_EDIT_URL)
class PlannedTransactionEditController {

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

    @GetMapping
    private String goToView() {

        return EDIT_VIEW;
    }

    @PostMapping
    private String save(PlannedTransactionForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return EDIT_VIEW;
        }

        plannedTransactionCommandService.save(form);

        return redirect("");
    }

    @ModelAttribute
    private void initData(@RequestParam(required = false) Long id, Authentication authentication, ModelMap modelMap) {

        modelMap.addAttribute(FORM_PAGE, getEditFormName(PLANNED_TRANSACTION))
                .addAttribute("plannedTransactionForm", plannedTransactionFormFactory.getForm(id))
                .addAttribute("currentlyLoggedInUser", extractCurrentUserDto(authentication))
                .addAttribute("action", PLANNED_TRANSACTION_EDIT_URL);

        if (isNull(id)) {

            modelMap.addAttribute("accountingPeriod", YearMonth.now().toString());
        }
    }

    @InitBinder("plannedTransactionFormValidator")
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(plannedTransactionFormValidator);
    }
}
