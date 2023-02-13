package pl.wsikora.successbudget.v3.category.ui.view;

import jakarta.servlet.http.HttpSession;
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

    private final CategoryViewControllerDataProvider dataProvider;

    private CategoryViewController(CategoryViewControllerDataProvider dataProvider) {

        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @ModelAttribute
    private void data(CategoryViewParameters parameters, HttpSession session, Model model) {

        model.addAllAttributes(dataProvider.provideData(parameters, session));
    }

}
