package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.title.TitleProvider;
import pl.wsikora.successbudget.v3.common.util.ui.ControllerDataProvider;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


@Service
class CategoryEditControllerDataProvider extends ControllerDataProvider {

    private final MessageProvider messageProvider;
    private final TitleProvider titleProvider;
    private final CategoryFormFactory categoryFormFactory;

    private CategoryEditControllerDataProvider(
        MessageProvider messageProvider,
        CategoryFormFactory categoryFormFactory
    ) {

        this.messageProvider = messageProvider;
        this.titleProvider = new TitleProvider(messageProvider);
        this.categoryFormFactory = categoryFormFactory;
    }

    ModelMap provideData(@Nullable Long categoryId) {

        ModelMap modelMap = new ModelMap();

        addAttributeLogoAppUrlDashboardPath(modelMap);

        addAttributeColumnSize(modelMap, FORM_PAGE_SIZE);

        addAttributePagePathFromForm(modelMap, CATEGORY);

        addAttributeFormAction(modelMap, CATEGORY_ADD_PATH);

        CategoryForm categoryForm = categoryFormFactory.getCategoryForm(categoryId);

        modelMap.addAttribute("categoryForm", categoryForm);

        String title = titleProvider.provideTitle(categoryForm.getCategoryId(),
            CATEGORY_ADD_TITLE, CATEGORY_EDIT_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, BreadcrumbElementsBuilder.builder(messageProvider)
            .addDashboard()
            .add(CATEGORY_LIST_TITLE, CATEGORY_PATH)
            .add(title)
            .build());

        modelMap.addAttribute("transactionTypes", TransactionType.getOrdinals());

        return modelMap;
    }

}
