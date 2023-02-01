package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;


@Controller
@RequestMapping(CATEGORY_EDIT_PATH)
class CategoryEditController {

    private final CategoryCommand categoryCommand;
    private final CategoryQuery categoryQuery;
    private final CategoryFormValidator categoryFormValidator;
    private final CategoryFormFactory categoryFormFactory;
    private final MessageProvider messageProvider;

    private CategoryEditController(CategoryCommand categoryCommand,
                                   CategoryQuery categoryQuery,
                                   CategoryFormValidator categoryFormValidator,
                                   CategoryFormFactory categoryFormFactory,
                                   MessageProvider messageProvider) {

        this.categoryCommand = categoryCommand;
        this.categoryQuery = categoryQuery;
        this.categoryFormValidator = categoryFormValidator;
        this.categoryFormFactory = categoryFormFactory;
        this.messageProvider = messageProvider;
    }

    @GetMapping
    private String goToView(@RequestParam(required = false) Long id, Principal principal, Model model) {

        if (isNull(id)) {

            String title = messageProvider.getMessage(CATEGORY_ADD_TITLE);

            model.addAttribute(CATEGORY_FORM, new CategoryForm())
                .addAttribute(PAGE_TITLE, title)
                .addAttribute(BREADCRUMB_ELEMENTS, List.of(
                    new BreadcrumbElement(messageProvider.getMessage(HOME_TITLE), HOME_PATH),
                    new BreadcrumbElement(title))
                );

            return EDIT_VIEW;
        }

        Username username = new Username(principal.getName());

        if (!categoryQuery.exists(id, username)) {

            return redirect(CATEGORY_EDIT_PATH);
        }

        String title = messageProvider.getMessage(CATEGORY_EDIT_TITLE);

        model.addAttribute(CATEGORY_FORM, categoryFormFactory.getCategoryForm(id))
            .addAttribute(PAGE_TITLE, title)
            .addAttribute(BREADCRUMB_ELEMENTS, List.of(
                new BreadcrumbElement(messageProvider.getMessage(HOME_TITLE), HOME_PATH),
                new BreadcrumbElement(title))
            );

        return EDIT_VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute CategoryForm categoryForm, BindingResult result, Principal principal) {

        if (result.hasErrors()) {

            return EDIT_VIEW;
        }

        Username username = new Username(principal.getName());

        categoryCommand.save(categoryForm, username);

        return redirect(CATEGORY_PATH);
    }

    @InitBinder("categoryFormValidator")
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(categoryFormValidator);
    }

    @ModelAttribute(FORM_PAGE)
    private String formPage() {

        return getEditFormName(CATEGORY);
    }

    @ModelAttribute(FORM_ACTION)
    private String formAction() {

        return CATEGORY_EDIT_PATH;
    }

    @ModelAttribute("assignedTransactionTypes")
    private List<Integer> assignedTransactionTypes() {

        return TransactionType.getOrdinals();
    }
}
