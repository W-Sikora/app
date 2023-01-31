package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.category.application.CategoryAttributes;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;
import pl.wsikora.successbudget.v3.category.application.CategoryUserAccessChecker;
import pl.wsikora.successbudget.v3.common.type.CategoryId;

import javax.validation.Valid;
import java.security.Principal;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.category.ui.CategoryUtils.CATEGORY_EDIT_VIEW;
import static pl.wsikora.successbudget.v3.category.ui.CategoryUtils.CATEGORY_PATH;
import static pl.wsikora.successbudget.v3.common.Constants.EDIT_PATH;
import static pl.wsikora.successbudget.v3.common.Constants.LACK_OF_AUTHORITY_VIEW;
import static pl.wsikora.successbudget.v3.common.Redirector.redirect;


@Controller
@RequestMapping(CATEGORY_PATH + EDIT_PATH)
class CategoryEditController {

    private final CategoryCommand categoryCommand;
    private final CategoryFormValidator categoryFormValidator;
    private final CategoryFormFactory categoryFormFactory;
    private final CategoryUserAccessChecker categoryUserAccessChecker;

    private CategoryEditController(CategoryCommand categoryCommand,
                                   CategoryFormValidator categoryFormValidator,
                                   CategoryFormFactory categoryFormFactory,
                                   CategoryUserAccessChecker categoryUserAccessChecker) {

        this.categoryCommand = categoryCommand;
        this.categoryFormValidator = categoryFormValidator;
        this.categoryFormFactory = categoryFormFactory;
        this.categoryUserAccessChecker = categoryUserAccessChecker;
    }

    @GetMapping
    private String goToView(@RequestParam(required = false) Long id, Principal principal, Model model) {

        if (isNull(id)) {

            model.addAttribute("form", new CategoryForm());

            return CATEGORY_EDIT_VIEW;
        }

        CategoryId categoryId = new CategoryId(id);

        Username username = new Username(principal.getName());

        if (!categoryUserAccessChecker.hasAccess(categoryId, username)) {

            return LACK_OF_AUTHORITY_VIEW;
        }

        model.addAttribute("form", categoryFormFactory.getCategoryForm(categoryId, username));

        return CATEGORY_EDIT_VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute CategoryAttributes categoryAttributes,
                        BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasErrors()) {

            return CATEGORY_EDIT_VIEW;
        }

        Username username = new Username(principal.getName());

        categoryCommand.save(categoryAttributes, username);

        return redirect(CATEGORY_PATH);
    }

    @InitBinder("categoryFormValidator")
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(categoryFormValidator);
    }
}
