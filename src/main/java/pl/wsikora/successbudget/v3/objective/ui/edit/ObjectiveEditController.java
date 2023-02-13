package pl.wsikora.successbudget.v3.objective.ui.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.successbudget.v3.objective.application.ObjectiveCommand;

import static pl.wsikora.successbudget.v3.common.util.Constants.*;
import static pl.wsikora.successbudget.v3.common.util.RedirectionUtils.redirect;


@Controller
@RequestMapping(OBJECTIVE_ADD_PATH)
class ObjectiveEditController {

    private final ObjectiveFormValidator objectiveFormValidator;
    private final ObjectiveCommand objectiveCommand;
    private final ObjectiveEditControllerDataProvider objectiveEditControllerDataProvider;

    public ObjectiveEditController(
        ObjectiveFormValidator objectiveFormValidator,
        ObjectiveCommand objectiveCommand,
        ObjectiveEditControllerDataProvider objectiveEditControllerDataProvider
    ) {

        this.objectiveFormValidator = objectiveFormValidator;
        this.objectiveCommand = objectiveCommand;
        this.objectiveEditControllerDataProvider = objectiveEditControllerDataProvider;
    }

    @GetMapping
    private String view() {

        return VIEW;
    }

    @PostMapping
    private String save(@ModelAttribute ObjectiveForm objectiveForm, Errors errors) {

        objectiveFormValidator.validateForm(objectiveForm, errors);

        if (errors.hasErrors()) {

            return VIEW;
        }

        objectiveCommand.save(objectiveForm);

        return redirect(OBJECTIVE_PATH);
    }

    @ModelAttribute
    private void data(@RequestParam(required = false) Long objectiveId, Model model) {

        model.addAllAttributes(objectiveEditControllerDataProvider.provideData(objectiveId));
    }

}
