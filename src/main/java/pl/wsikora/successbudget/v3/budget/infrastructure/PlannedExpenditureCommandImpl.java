package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureAttributes;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;
import pl.wsikora.successbudget.v3.common.type.Username;


@Service
class PlannedExpenditureCommandImpl implements PlannedExpenditureCommand {

    private final PlannedExpenditureRepository plannedExpenditureRepository;

    private PlannedExpenditureCommandImpl(PlannedExpenditureRepository plannedExpenditureRepository) {

        this.plannedExpenditureRepository = plannedExpenditureRepository;
    }

    @Override
    public void save(PlannedExpenditureAttributes plannedExpenditureAttributes, Username username) {


    }

    @Override
    public void delete(Long plannedExpenditureId) {

        plannedExpenditureRepository.deleteByPlannedExpenditureId(plannedExpenditureId);
    }
}
