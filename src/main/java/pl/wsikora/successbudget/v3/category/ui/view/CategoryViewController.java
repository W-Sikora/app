package pl.wsikora.successbudget.v3.category.ui.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.category.application.CategoryDto;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.security.Principal;
import java.util.List;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getListName;


@Controller
@RequestMapping(CATEGORY_PATH)
class CategoryViewController {

    private final CategoryQuery categoryQuery;
    private final MessageProvider messageProvider;

    public CategoryViewController(CategoryQuery categoryQuery, MessageProvider messageProvider) {

        this.categoryQuery = categoryQuery;
        this.messageProvider = messageProvider;
    }

    @GetMapping
    private String goToView() {

        return LIST_VIEW;
    }

    @ModelAttribute(LIST_PAGE)
    private String listPage() {

        return getListName(CATEGORY);
    }

    @ModelAttribute("categories")
    private List<CategoryDto> list(Principal principal) {

        Username username = new Username(principal.getName());

        return categoryQuery.getAllCategoryDto(username);
    }

    @ModelAttribute("editUrl")
    private String editUrl() {

        return CATEGORY_EDIT_PATH + ID_PATH_QUERY;
    }

    @ModelAttribute("deleteUrl")
    private String deleteUrl() {

        return CATEGORY_DELETE_PATH;
    }

    @ModelAttribute(BREADCRUMB_ELEMENTS)
    private List<BreadcrumbElement> breadcrumbElements() {

        return List.of(
            new BreadcrumbElement(messageProvider.getMessage(HOME_TITLE), HOME_PATH),
            new BreadcrumbElement(CATEGORY_LIST_TITLE)
        );
    }

    @ModelAttribute(PAGE_TITLE)
    private String pageTitle() {

        return messageProvider.getMessage(CATEGORY_LIST_TITLE);
    }
}
