package pl.wsikora.successbudget.v3.objective.ui.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;


@Controller
@RequestMapping(OBJECTIVE_PATH)
public class ObjectiveViewController {

    private final ObjectiveViewControllerDataProvider objectiveViewControllerDataProvider;

    private ObjectiveViewController(ObjectiveViewControllerDataProvider objectiveViewControllerDataProvider) {

        this.objectiveViewControllerDataProvider = objectiveViewControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @ModelAttribute
    private void data(@RequestParam(defaultValue = DEFAULT_PAGINATION_PAGE) int page,
                      @RequestParam(defaultValue = DEFAULT_PAGINATION_SIZE) int size,
                      @RequestParam(required = false) String keyword,
                      Model model) {

        model.addAllAttributes(objectiveViewControllerDataProvider.provideData(page, size, keyword));
    }

}
