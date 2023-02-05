package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.category.application.CategoryQuery;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.type.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.type.TransactionType;
import pl.wsikora.successbudget.v3.common.util.MessageProvider;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;


@Service
class CategoryEditControllerDataProvider {

    private final MessageProvider messageProvider;
    private final CategoryFormFactory categoryFormFactory;
    private final CategoryQuery categoryQuery;

    private CategoryEditControllerDataProvider(MessageProvider messageProvider,
                                               CategoryFormFactory categoryFormFactory,
                                               CategoryQuery categoryQuery) {

        this.messageProvider = messageProvider;
        this.categoryFormFactory = categoryFormFactory;
        this.categoryQuery = categoryQuery;
    }

    ModelMap provideData(Long categoryId) {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(PAGE_PATH, getEditFormName(CATEGORY));

        modelMap.addAttribute(FORM, categoryFormFactory.getCategoryForm(categoryId));

        modelMap.addAttribute(FORM_ACTION, CATEGORY_EDIT_PATH);

        boolean categoryEdition = categoryQuery.exists(categoryId);

        String title = categoryEdition ? messageProvider.getMessage(CATEGORY_EDIT_TITLE)
            : messageProvider.getMessage(CATEGORY_ADD_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute("assignedTransactionTypes", TransactionType.getOrdinals());

        return modelMap;
    }

}
