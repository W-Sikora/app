package pl.wsikora.successbudget.v3.category.ui.view;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.ui.validation.PaginationValidator;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getListViewName;


@Service
class CategoryViewControllerDataProvider {

    private final MessageProvider messageProvider;
    private final CategoryQuery categoryQuery;

    private CategoryViewControllerDataProvider(
        MessageProvider messageProvider,
        CategoryQuery categoryQuery
    ) {

        this.messageProvider = messageProvider;
        this.categoryQuery = categoryQuery;
    }

    ModelMap provideData(CategoryViewParameters parameters) {

        Assert.notNull(parameters, "parameters must not be null");

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(PAGE_PATH, getListViewName(CATEGORY));

        modelMap.addAttribute(COLUMN_SIZE, "is-7");

        String title = messageProvider.getMessage(CATEGORY_LIST_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard()
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute(ADD_URL, CATEGORY_EDIT_PATH);

        String keyword = parameters.keyword();

        modelMap.addAttribute(KEYWORD, keyword);

        Integer page = parameters.page();

        Integer size = parameters.size();

        if (PaginationValidator.isValid(page, size)) {

            Pageable pageable = PageRequest.of(page, size);

            modelMap.addAttribute(CURRENT_PAGE, pageable.getPageNumber());

            modelMap.addAttribute("categories", categoryQuery.findAll(pageable, keyword));
        }

        return modelMap;
    }

}
