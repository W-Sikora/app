package pl.wsikora.successbudget.v3.objective.ui.view;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElement;
import pl.wsikora.successbudget.v3.common.breadcrumb.BreadcrumbElementsBuilder;
import pl.wsikora.successbudget.v3.common.util.message.MessageProvider;
import pl.wsikora.successbudget.v3.common.util.validation.PaginationValidator;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveQuery;

import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.getListName;


@Service
class ObjectiveViewControllerDataProvider {

    private final MessageProvider messageProvider;
    private final ObjectiveQuery objectiveQuery;

    private ObjectiveViewControllerDataProvider(MessageProvider messageProvider,
                                                ObjectiveQuery objectiveQuery) {

        this.messageProvider = messageProvider;
        this.objectiveQuery = objectiveQuery;
    }

    ModelMap provideData(int page, int size, String keyword) {

        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute(LOGO_APP_URL, DASHBOARD_PATH);

        modelMap.addAttribute(PAGE_PATH, getListName(CATEGORY));

        modelMap.addAttribute(COLUMN_SIZE, "is-10");

        String title = messageProvider.getMessage(OBJECTIVE_LIST_TITLE);

        modelMap.addAttribute(PAGE_TITLE, title);

        List<BreadcrumbElement> breadcrumbElements = BreadcrumbElementsBuilder.builder()
            .add(messageProvider.getMessage(DASHBOARD_TITLE), DASHBOARD_PATH)
            .add(title)
            .build();

        modelMap.addAttribute(BREADCRUMB_ELEMENTS, breadcrumbElements);

        modelMap.addAttribute(ADD_URL, OBJECTIVE_EDIT_PATH);

        modelMap.addAttribute(EDIT_URL, OBJECTIVE_EDIT_PATH + ID_PATH_QUERY);

        modelMap.addAttribute(KEYWORD, keyword);

        if (PaginationValidator.isValid(page, size)) {

            Pageable pageable = PageRequest.of(page, size);

            modelMap.addAttribute(CURRENT_PAGE, pageable.getPageNumber() + 1);

            modelMap.addAttribute("objectives", objectiveQuery.findAll(pageable, keyword));
        }

        return modelMap;
    }

}
