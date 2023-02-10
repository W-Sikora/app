package pl.wsikora.successbudget.v3.category.ui.view;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.validation.PaginationValidator;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getListName;


@Service
class CategoryViewControllerDataProvider {

    private final MessageProvider messageProvider;
    private final CategoryQuery categoryQuery;

    private CategoryViewControllerDataProvider(MessageProvider messageProvider,
                                               CategoryQuery categoryQuery) {

        this.messageProvider = messageProvider;
        this.categoryQuery = categoryQuery;
    }

    ModelMap provideData(int page, int size, @Nullable String keyword) {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(PAGE_PATH, getListName(CATEGORY));

        modelMap.addAttribute(COLUMN_SIZE, "is-7");

        String title = messageProvider.getMessage(CATEGORY_LIST_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute(ADD_URL, CATEGORY_EDIT_PATH);

        modelMap.addAttribute(EDIT_URL, CATEGORY_EDIT_PATH + ID_PATH_QUERY);

        modelMap.addAttribute(DELETE_URL, CATEGORY_DELETE_PATH);

        modelMap.addAttribute(KEYWORD, keyword);

        if (PaginationValidator.isValid(page, size)) {

            Pageable pageable = PageRequest.of(page, size);

            modelMap.addAttribute(CURRENT_PAGE, pageable.getPageNumber() + 1);

            modelMap.addAttribute("categories", categoryQuery.findAll(pageable, keyword));
        }

        return modelMap;
    }

}
