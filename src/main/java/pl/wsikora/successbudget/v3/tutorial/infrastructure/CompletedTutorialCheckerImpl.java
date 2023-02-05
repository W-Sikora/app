package pl.wsikora.successbudget.v3.tutorial.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.tutorial.application.CompletedTutorialChecker;


@Service
class CompletedTutorialCheckerImpl implements CompletedTutorialChecker {

    private final TutorialRepository tutorialRepository;

    private CompletedTutorialCheckerImpl(TutorialRepository tutorialRepository) {

        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public boolean isCompleted() {

        return tutorialRepository.getLastCompletedStep() == 8;
    }
}
