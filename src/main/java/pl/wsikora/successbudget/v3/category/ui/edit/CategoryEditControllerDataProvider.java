package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;

import java.util.List;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getEditFormName;


@Service
class CategoryEditControllerDataProvider {

    private final MessageProvider messageProvider;
    private final CategoryFormFactory categoryFormFactory;

    private CategoryEditControllerDataProvider(MessageProvider messageProvider,
                                               CategoryFormFactory categoryFormFactory) {

        this.messageProvider = messageProvider;
        this.categoryFormFactory = categoryFormFactory;
    }

    ModelMap provideData(@Nullable Long categoryId) {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(COLUMN_SIZE, "is-5");

        modelMap.addAttribute(PAGE_PATH, getEditFormName(CATEGORY));

        modelMap.addAttribute(FORM_ACTION, CATEGORY_EDIT_PATH);

        CategoryForm categoryForm = categoryFormFactory.getCategoryForm(categoryId);

        modelMap.addAttribute("categoryForm", categoryForm);

        String title = isNull(categoryForm.getCategoryId())
            ? messageProvider.getMessage(CATEGORY_ADD_TITLE)
            : messageProvider.getMessage(CATEGORY_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(messageProvider.getMessage(CATEGORY_LIST_TITLE), CATEGORY_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute("transactionTypes", TransactionType.getOrdinals());

        return modelMap;
    }

}
