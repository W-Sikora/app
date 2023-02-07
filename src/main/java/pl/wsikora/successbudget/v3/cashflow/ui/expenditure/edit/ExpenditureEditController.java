package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.common.type.Username;

import javax.validation.Valid;
import java.security.Principal;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;

@Controller
@RequestMapping("/aa")
public class ExpenditureEditController {

    private final CategoryQuery categoryQuery;

    public ExpenditureEditController(CategoryQuery categoryQuery) {

        this.categoryQuery = categoryQuery;
    }

    @GetMapping
    private String goToView(@RequestParam(required = false) Long id, Principal principal, Model model) {

        return VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute ExpenditureForm expenditureForm, BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        Username username = new Username(principal.getName());

        return redirect(CATEGORY_PATH);
    }


    @ModelAttribute(FORM_PAGE)
    private String formPage() {

        return getEditFormName("expenditure");
    }

    @ModelAttribute("expenditureForm")
    private ExpenditureForm form() {

        return new ExpenditureForm();
    }

    @ModelAttribute(FORM_ACTION)
    private String formAction() {

        return "aa";
    }
}
