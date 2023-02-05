package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueAttributes;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;
import pl.wsikora.successbudget.v3.common.type.Username;


@Service
class PlannedRevenueCommandImpl implements PlannedRevenueCommand {

    private final PlannedRevenueRepository plannedRevenueRepository;

    private PlannedRevenueCommandImpl(PlannedRevenueRepository plannedRevenueRepository) {

        this.plannedRevenueRepository = plannedRevenueRepository;
    }

    @Override
    public void save(PlannedRevenueAttributes plannedRevenueAttributes, Username username) {

    }

    @Override
    public void delete(Long plannedExpenditureId) {

        plannedRevenueRepository.deleteByPlannedRevenueId(plannedExpenditureId);
    }
}
