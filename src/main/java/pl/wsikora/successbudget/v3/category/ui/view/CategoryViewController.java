package pl.wsikora.successbudget.v3.category.ui.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.category.application.CategoryUserAccessChecker;
import pl.wsikora.successbudget.v3.common.type.CategoryId;

import java.security.Principal;

import static pl.wsikora.successbudget.v3.category.ui.CategoryUtils.*;
import static pl.wsikora.successbudget.v3.common.Constants.ID_PATH_VARIABLE;
import static pl.wsikora.successbudget.v3.common.Constants.LACK_OF_AUTHORITY_VIEW;


@Controller
@RequestMapping(CATEGORY_PATH)
class CategoryViewController {

    private final CategoryQuery categoryQuery;
    private final CategoryUserAccessChecker categoryUserAccessChecker;

    private CategoryViewController(CategoryQuery categoryQuery,
                                   CategoryUserAccessChecker categoryUserAccessChecker) {

        this.categoryQuery = categoryQuery;
        this.categoryUserAccessChecker = categoryUserAccessChecker;
    }

    @GetMapping
    private String goToView(Model model, Principal principal) {

        Username username = new Username(principal.getName());

        model.addAttribute("categories", categoryQuery.getAllCategoryDto(username));

        return CATEGORY_VIEW;
    }

    @GetMapping(ID_PATH_VARIABLE)
    private String goToView(@PathVariable Long id, Principal principal, Model model) {

        CategoryId categoryId = new CategoryId(id);

        Username username = new Username(principal.getName());

        if (!categoryUserAccessChecker.hasAccess(categoryId, username)) {

            return LACK_OF_AUTHORITY_VIEW;
        }

        model.addAttribute("category", categoryQuery.getCategoryDto(categoryId, username));

        return CATEGORY_DETAIL_VIEW;
    }
}
