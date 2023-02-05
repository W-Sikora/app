package pl.wsikora.successbudget.v3.tutorial.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.tutorial.application.LastCompletedStepProvider;


@Service
class LastCompletedStepProviderImpl implements LastCompletedStepProvider {

    private final TutorialRepository tutorialRepository;

    private LastCompletedStepProviderImpl(TutorialRepository tutorialRepository) {

        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public int getLastCompletedStep() {

        return tutorialRepository.getLastCompletedStep();
    }
}
