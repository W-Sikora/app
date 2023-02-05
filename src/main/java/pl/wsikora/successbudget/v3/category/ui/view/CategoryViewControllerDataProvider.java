package pl.wsikora.successbudget.v3.category.ui.view;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.Constants.*;
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

    ModelMap provideData(Pageable pageable) {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(PAGE_PATH, getListName(CATEGORY));

        String title = messageProvider.getMessage(CATEGORY_LIST_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute(EDIT_URL, CATEGORY_EDIT_PATH + ID_PATH_QUERY);

        modelMap.addAttribute(DELETE_URL, CATEGORY_DELETE_PATH);

        modelMap.addAttribute("categories", categoryQuery.getAllCategoryDto(pageable));

        return modelMap;
    }

}
