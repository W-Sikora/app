package pl.wsikora.successbudget.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/{prefix}/{viewName}")
public class AllControllers {

    @GetMapping
    private String view(@PathVariable String prefix, @PathVariable String viewName) {

        return prefix + "/" + viewName;
    }
}
