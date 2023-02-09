//package pl.wsikora.successbudget.v3.dashboard.ui.create;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import pl.wsikora.successbudget.v3.budget.application.budget.BudgetCommand;
//import pl.wsikora.successbudget.v3.budget.ui.budget.create.BudgetValidator;
//import pl.wsikora.successbudget.v3.common.username.Username;
//
//import java.security.Principal;
//import java.time.YearMonth;
//
//
//@RestController
//@RequestMapping
//class DashboardCreateController {
//
//    private final BudgetCommand budgetCommand;
//    private final BudgetValidator budgetValidator;
//
//    private BudgetCreateController(BudgetCommand budgetCommand,
//                                   BudgetValidator budgetValidator) {
//
//        this.budgetCommand = budgetCommand;
//        this.budgetValidator = budgetValidator;
//    }
//
//    @PostMapping
//    private ResponseEntity<?> create(@RequestParam String period, Principal principal) {
//
//        if (budgetValidator.isValid(period)) {
//
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        Username username = new Username(principal.getName());
//
//        YearMonth yearMonth = YearMonth.parse(period);
//
//        budgetCommand.create(yearMonth, username);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//}
