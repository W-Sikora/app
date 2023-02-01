//package pl.wsikora.successbudget.v3.cashflow.ui.revenue.delete;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.wsikora.successbudget.v3.cashflow.infrastructure.RevenueRepository;
//
//import java.security.Principal;
//
//import static pl.wsikora.successbudget.v3.common.Constants.ID_PATH_VARIABLE;
//import static pl.wsikora.successbudget.v3.common.util.Redirector.redirect;
//
//
//@Controller
//@RequestMapping(REVENUE_DELETE_PATH)
//class RevenueDeleteController {
//
//    private final RevenueRepository revenueRepository;
//
//    private RevenueDeleteController(RevenueRepository revenueRepository) {
//
//        this.revenueRepository = revenueRepository;
//    }
//
//    @PostMapping(ID_PATH_VARIABLE)
//    private String delete(@PathVariable Long id, Principal principal) {
//
//        if (revenueRepository.existsByRevenueIdAndUsername(id, principal.getName())) {
//
//            revenueRepository.deleteById(id);
//        }
//
//        return redirect(REVENUE_PATH);
//    }
//}
