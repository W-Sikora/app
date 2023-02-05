package pl.wsikora.successbudget.v3.dashboard.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.tutorial.application.CompletedTutorialChecker;


@Service("dashboard-completedTutorialCheckerImpl")
class CompletedTutorialCheckerImpl implements pl.wsikora.successbudget.v3.dashboard.application.CompletedTutorialChecker {

    private final CompletedTutorialChecker completedTutorialChecker;

    private CompletedTutorialCheckerImpl(CompletedTutorialChecker completedTutorialChecker) {

        this.completedTutorialChecker = completedTutorialChecker;
    }

    @Override
    public boolean isCompleted() {

        return completedTutorialChecker.isCompleted();
    }
}
