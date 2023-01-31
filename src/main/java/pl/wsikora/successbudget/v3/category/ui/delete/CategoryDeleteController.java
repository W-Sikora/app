package pl.wsikora.successbudget.v3.category.ui.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;
import pl.wsikora.successbudget.v3.category.application.CategoryUserAccessChecker;
import pl.wsikora.successbudget.v3.common.type.CategoryId;

import java.security.Principal;

import static pl.wsikora.successbudget.v3.category.ui.CategoryUtils.CATEGORY_PATH;
import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.Redirector.redirect;


@Controller
@RequestMapping(CATEGORY_PATH + DELETE_PATH)
class CategoryDeleteController {

    private final CategoryCommand categoryCommand;
    private final CategoryUserAccessChecker categoryUserAccessChecker;

    private CategoryDeleteController(CategoryCommand categoryCommand,
                                     CategoryUserAccessChecker categoryUserAccessChecker) {

        this.categoryCommand = categoryCommand;
        this.categoryUserAccessChecker = categoryUserAccessChecker;
    }

    @PostMapping(ID_PATH_VARIABLE)
    private String delete(@PathVariable Long id, Principal principal) {

        Username username = new Username(principal.getName());

        CategoryId categoryId = new CategoryId(id);

        if (!categoryUserAccessChecker.hasAccess(categoryId, username)) {

            return LACK_OF_AUTHORITY_VIEW;
        }

        categoryCommand.delete(categoryId);

        return redirect(CATEGORY_PATH);
    }
}
