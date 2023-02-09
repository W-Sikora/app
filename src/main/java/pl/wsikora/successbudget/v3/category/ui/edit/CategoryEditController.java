package pl.wsikora.successbudget.v3.category.ui.edit;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;

import static pl.wsikora.successbudget.v3.common.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;


@Controller
@RequestMapping(CATEGORY_EDIT_PATH)
class CategoryEditController {

    private final CategoryCommand categoryCommand;
    private final CategoryFormValidator categoryFormValidator;
    private final CategoryEditControllerDataProvider categoryEditControllerDataProvider;

    private CategoryEditController(CategoryCommand categoryCommand,
                                   CategoryFormValidator categoryFormValidator,
                                   CategoryEditControllerDataProvider categoryEditControllerDataProvider) {

        this.categoryCommand = categoryCommand;
        this.categoryFormValidator = categoryFormValidator;
        this.categoryEditControllerDataProvider = categoryEditControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@Valid @ModelAttribute CategoryForm categoryForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return VIEW;
        }

        categoryCommand.save(categoryForm);

        return redirect(CATEGORY_PATH);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(categoryFormValidator);
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) Long id, Model model) {

        model.addAllAttributes(categoryEditControllerDataProvider.provideData(id));
    }

}
