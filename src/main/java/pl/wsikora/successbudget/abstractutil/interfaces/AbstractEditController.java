package pl.wsikora.successbudget.abstractutil.interfaces;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class AbstractEditController<Form> {

    @GetMapping
    protected abstract String goToView();

    @PostMapping
    protected abstract String save(@Valid @ModelAttribute Form form, BindingResult bindingResult);

    @ModelAttribute
    protected abstract void initData(@RequestParam(required = false) Long id, ModelMap modelMap);

    @InitBinder
    protected abstract void initBinder(WebDataBinder binder);
}
