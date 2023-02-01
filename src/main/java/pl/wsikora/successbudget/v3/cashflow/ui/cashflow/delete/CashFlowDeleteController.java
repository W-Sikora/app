//package pl.wsikora.successbudget.v3.cashflow.ui.cashflow.delete;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.wsikora.successbudget.v3.cashflow.infrastructure.CashFlowRepository;
//
//import java.security.Principal;
//
//import static pl.wsikora.successbudget.v3.common.Constants.ID_PATH_VARIABLE;
//import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;
//
//
//@Controller
//@RequestMapping(CASH_FLOW_DELETE_PATH)
//class CashFlowDeleteController {
//
//    private final CashFlow cashFlowRepository;
//
//    private CashFlowDeleteController(CashFlowRepository cashFlowRepository) {
//
//        this.cashFlowRepository = cashFlowRepository;
//    }
//
//    @PostMapping(ID_PATH_VARIABLE)
//    private String delete(@PathVariable Long id, Principal principal) {
//
//        if (cashFlowRepository.existsByCashFlowIdAndUsername(id, principal.getName())) {
//
//            cashFlowRepository.deleteById(id);
//        }
//
//        return redirect(CASH_FLOW_PATH);
//    }
//}
