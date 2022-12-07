package pl.wsikora.successbudget.category.interfaces.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsikora.successbudget.category.application.command.CategoryCommandService;


@Controller
@RequestMapping("/categories")
class CategoryEditController {

    private final CategoryCommandService categoryCommandService;
    private final CategoryFormValidator categoryFormValidator;
    private final CategoryFormFactory categoryFormFactory;

    private CategoryEditController(CategoryCommandService categoryCommandService,
                                   CategoryFormValidator categoryFormValidator,
                                   CategoryFormFactory categoryFormFactory) {

        this.categoryCommandService = categoryCommandService;
        this.categoryFormValidator = categoryFormValidator;
        this.categoryFormFactory = categoryFormFactory;
    }
}
