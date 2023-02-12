package pl.wsikora.successbudget.v3.category.ui.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.category.application.CategoryCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.CATEGORY_DELETE_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.CATEGORY_PATH;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(CATEGORY_DELETE_PATH)
class CategoryDeleteController {

    private final CategoryCommand categoryCommand;

    private CategoryDeleteController(CategoryCommand categoryCommand) {

        this.categoryCommand = categoryCommand;
    }

    @PostMapping
    private String delete(@PathVariable Long categoryId) {

        categoryCommand.delete(categoryId);

        return redirect(CATEGORY_PATH);
    }

}
