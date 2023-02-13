package pl.wsikora.successbudget.v3.objective.ui.view;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static pl.wsikora.successbudget.v3.common.util.Constants.OBJECTIVE_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.VIEW;


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
    private void data(ObjectiveViewParameters parameters, HttpSession session, Model model) {

        model.addAllAttributes(objectiveViewControllerDataProvider.provideData(parameters, session));
    }

}
