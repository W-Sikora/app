package pl.wsikora.successbudget.v3.category.ui.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


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
    private void data(@RequestParam(defaultValue = DEFAULT_PAGINATION_PAGE) int page,
                      @RequestParam(defaultValue = DEFAULT_PAGINATION_SIZE) int size,
                      @RequestParam(required = false) String keyword,
                      Model model) {

        model.addAllAttributes(categoryViewControllerDataProvider.provideData(page, size, keyword));
    }

}
