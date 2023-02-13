package pl.wsikora.successbudget.v3.category.ui.edit;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(CATEGORY_ADD_PATH)
class CategoryEditController {

    private final CategoryCommand categoryCommand;
    private final CategoryFormValidator categoryFormValidator;
    private final CategoryEditControllerDataProvider dataProvider;

    private CategoryEditController(
        CategoryCommand categoryCommand,
        CategoryFormValidator categoryFormValidator,
        CategoryEditControllerDataProvider dataProvider
    ) {

        this.categoryCommand = categoryCommand;
        this.categoryFormValidator = categoryFormValidator;
        this.dataProvider = dataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@ModelAttribute CategoryForm categoryForm, Errors errors) {

        categoryFormValidator.validateForm(categoryForm, errors);

        if (errors.hasErrors()) {

            return VIEW;
        }

        categoryCommand.save(categoryForm);

        return redirect(CATEGORY_PATH);
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) Long categoryId, HttpSession session, Model model) {

        model.addAllAttributes(dataProvider.provideData(categoryId, session));
    }

}
