package pl.wsikora.successbudget.v3.category.ui.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static pl.wsikora.successbudget.v3.common.util.Constants.CATEGORY_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;


@Controller
@RequestMapping(CATEGORY_PATH)
class CategoryViewController {

    private final CategoryViewControllerDataProvider categoryViewControllerDataProvider;

    private CategoryViewController(CategoryViewControllerDataProvider categoryViewControllerDataProvider) {

        this.categoryViewControllerDataProvider = categoryViewControllerDataProvider;
    }

    @GetMapping
    private String goToView() {

        return VIEW;
    }

    @ModelAttribute
    private void data(CategoryViewParameters parameters, Model model) {

        model.addAllAttributes(categoryViewControllerDataProvider.provideData(parameters));
    }

}
