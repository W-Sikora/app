package pl.wsikora.successbudget.v3.objective.ui.edit;

import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.type.description.DescriptionValidator;
import pl.wsikora.successbudget.v3.common.type.title.TitleValidator;


class ObjectiveFormValidator extends AbstractFormValidator<ObjectiveForm> {

    private final TitleValidator titleValidator;
    private final DescriptionValidator descriptionValidator;

    ObjectiveFormValidator(TitleValidator titleValidator, DescriptionValidator descriptionValidator) {

        this.titleValidator = titleValidator;
        this.descriptionValidator = descriptionValidator;
    }

    @Override
    public void validateForm(ObjectiveForm objectiveForm, Errors errors) {

        titleValidator.validateForm(objectiveForm.getTitle(), errors);

        descriptionValidator.validateForm(objectiveForm.getDescription(), errors);

    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(ObjectiveForm.class);
    }

}
