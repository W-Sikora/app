package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.budget.infrastructure.BudgetRepository;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElement;

import java.util.List;

import static pl.wsikora.successbudget.v3.budget.ui.budget.BudgetConstants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getListName;


@Controller
@RequestMapping(BUDGET_PATH)
class BudgetViewController {

    private final BudgetRepository budgetRepository;
    private final MessageProvider messageProvider;

    public BudgetViewController(BudgetRepository budgetRepository, MessageProvider messageProvider) {

        this.budgetRepository = budgetRepository;
        this.messageProvider = messageProvider;
    }

    @GetMapping
    private String goToView() {

        return LIST_VIEW;
    }

    @ModelAttribute(LIST_PAGE)
    private String listPage() {

        return getListName(BUDGET);
    }

//    @ModelAttribute()
//    private String list() {
//
//        return categoryRepository
//    }

    @ModelAttribute("editUrl")
    private String editUrl() {

        return BUDGET_EDIT_PATH + ID_PATH_QUERY;
    }

    @ModelAttribute("deleteUrl")
    private String deleteUrl() {

        return BUDGET_DELETE_PATH;
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

        return messageProvider.getMessage(BUDGET_LIST_TITLE);
    }
}
