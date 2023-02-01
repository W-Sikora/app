//package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.delete;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.wsikora.successbudget.v3.cashflow.infrastructure.ExpenditureRepository;
//
//import java.security.Principal;
//
//import static pl.wsikora.successbudget.v3.common.Constants.ID_PATH_VARIABLE;
//import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;
//
//
//@Controller
//@RequestMapping(EXPENDITURE_DELETE_PATH)
//class ExpenditureDeleteController {
//
//    private final ExpenditureRepository expenditureRepository;
//
//    private ExpenditureDeleteController(ExpenditureRepository expenditureRepository) {
//
//        this.expenditureRepository = expenditureRepository;
//    }
//
//    @PostMapping(ID_PATH_VARIABLE)
//    private String delete(@PathVariable Long id, Principal principal) {
//
//        if (expenditureRepository.existsByExpenditureIdAndUsername(id, principal.getName())) {
//
//            expenditureRepository.deleteById(id);
//        }
//
//        return redirect(EXPENDITURE_PATH);
//    }
//}
