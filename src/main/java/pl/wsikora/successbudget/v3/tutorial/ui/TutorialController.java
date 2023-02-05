package pl.wsikora.successbudget.v3.tutorial.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.v3.tutorial.application.LastCompletedStepProvider;

import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;
import static pl.wsikora.successbudget.v3.tutorial.ui.TutorialController.TUTORIAL_PATH;


@Controller
@RequestMapping(TUTORIAL_PATH)
public class TutorialController {

    public static final String TUTORIAL_PATH = "/tutorial/step";

    private final LastCompletedStepProvider lastCompletedStepProvider;

    private TutorialController(LastCompletedStepProvider lastCompletedStepProvider) {

        this.lastCompletedStepProvider = lastCompletedStepProvider;
    }

    @GetMapping
    private String step() {

        int lastCompletedStep = lastCompletedStepProvider.getLastCompletedStep();

        return redirect(TUTORIAL_PATH, lastCompletedStep + 1);
    }
}
