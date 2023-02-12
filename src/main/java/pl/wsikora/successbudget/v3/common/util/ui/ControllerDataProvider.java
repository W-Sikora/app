package pl.wsikora.successbudget.v3.common.util.ui;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.util.ui.validation.PaginationValidator;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.Constants.NO_RESOURCE;
import static pl.wsikora.successbudget.v3.common.util.ControllerUtils.*;
import static pl.wsikora.successbudget.v3.common.util.StringUtils.fillPath;


public abstract class ControllerDataProvider {

    private void addAttributeLogoAppUrl(ModelMap modelMap, String path) {

        Assert.notNull(modelMap, "modelMap must not be null");
        Assert.hasText(path, "path must not be empty");

        modelMap.addAttribute(LOGO_APP_URL, path);
    }

    protected void addAttributeLogoAppUrlLandingPagePath(ModelMap modelMap) {

        addAttributeLogoAppUrl(modelMap, LANDING_PAGE_PATH);
    }

    protected void addAttributeLogoAppUrlDashboardPath(ModelMap modelMap) {

        addAttributeLogoAppUrl(modelMap, DASHBOARD_PATH);
    }

    protected void addAttributeColumnSize(ModelMap modelMap, int size) {

        Assert.notNull(modelMap, "modelMap must not be null");
        Assert.isTrue(size > 0 && size < 13, "size must be of valid value");

        modelMap.addAttribute(COLUMN_SIZE, "is-" + size);
    }

    private void addAttributePagePath(ModelMap modelMap, String pagePath) {

        Assert.notNull(modelMap, "modelMap must not be null");
        Assert.hasText(pagePath, "pagePath must not be empty");

        modelMap.addAttribute(PAGE_PATH, pagePath);

    }

    protected void addAttributePagePathFromCommon(ModelMap modelMap, String pageName) {

        Assert.hasText(pageName, "pageName must not be empty");

        addAttributePagePath(modelMap, getCommonViewName(pageName));
    }

    protected void addAttributePagePathNoResource(ModelMap modelMap) {

        addAttributePagePathFromCommon(modelMap, NO_RESOURCE);
    }

    protected void addAttributePagePathFromForm(ModelMap modelMap, String pageName) {

        Assert.hasText(pageName, "pageName must not be empty");

        addAttributePagePath(modelMap, getEditFormViewName(pageName));
    }

    protected void addAttributePagePathFromListView(ModelMap modelMap, String pageName) {

        Assert.hasText(pageName, "pageName must not be empty");

        addAttributePagePath(modelMap, getListViewName(pageName));
    }

    protected void addAttributeFormAction(ModelMap modelMap, String path) {

        Assert.notNull(modelMap, "modelMap must not be null");
        Assert.hasText(path, "path must not be empty");

        modelMap.addAttribute(FORM_ACTION, path);
    }

    protected void addAttributeFormAction(ModelMap modelMap, String path, String elementToFill, Long identifier) {

        Assert.notNull(modelMap, "modelMap must not be null");
        Assert.hasText(path, "path must not be empty");
        Assert.hasText(elementToFill, "elementToFill must not be empty");
        Assert.notNull(identifier, "identifier must not be null");

        String filledPath = fillPath(path, elementToFill, identifier);

        modelMap.addAttribute(FORM_ACTION, filledPath);
    }

}
