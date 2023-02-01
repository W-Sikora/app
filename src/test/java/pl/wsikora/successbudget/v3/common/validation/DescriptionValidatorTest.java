package pl.wsikora.successbudget.v3.common.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.Description;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.type.Description.MAXIMUM_LENGTH;
import static pl.wsikora.successbudget.v3.common.type.Description.MINIMUM_LENGTH;
import static pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS;
import static pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;
import static pl.wsikora.successbudget.v3.common.validation.DescriptionValidator.F_DESCRIPTION;


class DescriptionValidatorTest {

    @Mock
    private Errors errors;
    private DescriptionValidator descriptionValidator;

    @BeforeEach
    void setUp() {

        openMocks(this);

        descriptionValidator = new DescriptionValidator();
    }
    
    @Test
    void shouldDetectBlankDescription() {

        // given
        String description = SPACE;

        // when
        descriptionValidator.validateForm(description, errors);

        // then
        verify(errors).rejectValue(F_DESCRIPTION, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortDescription() {

        // given
        String description = randomAlphabetic(MINIMUM_LENGTH - 1);

        // when
        descriptionValidator.validateForm(description, errors);

        // then
        verify(errors).rejectValue(F_DESCRIPTION, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Description.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongDescription() {

        // given
        String description = randomAlphabetic(MAXIMUM_LENGTH + 1);

        // when
        descriptionValidator.validateForm(description, errors);

        // then
        verify(errors).rejectValue(F_DESCRIPTION, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Description.getLengthRange(), EMPTY);
    }
}
