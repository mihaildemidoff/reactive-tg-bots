package io.github.mihaildemidoff.reactive.tg.bots.core.validation;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.MethodValidationException;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class ValidatorValidationServiceTest {

    @InjectMocks
    private ValidatorValidationService service;

    @Mock
    private Validator validator;

    @Test
    void testNoValidationError() {
        final ExampleModel model = new ExampleModel(RandomUtils.nextLong());
        Mockito.when(validator.validate(ArgumentMatchers.eq(model)))
                .thenReturn(Set.of());
        service.validateMethod(model);
    }

    @Test
    void testValidationError() {
        final ExampleModel model = new ExampleModel(RandomUtils.nextLong());
        final ConstraintViolation<ExampleModel> violation1 = Mockito.mock(ConstraintViolation.class);
        final Path path = Mockito.mock(Path.class);
        final Set<ConstraintViolation<ExampleModel>> violations = Set.of(violation1);
        Mockito.when(validator.validate(ArgumentMatchers.eq(model)))
                .thenReturn(violations);
        Mockito.when(violation1.getPropertyPath())
                .thenReturn(path);
        final String pathValue = RandomStringUtils.randomAlphabetic(10);
        Mockito.when(path.toString())
                .thenReturn(pathValue);
        final String invalidValue = RandomStringUtils.randomAlphabetic(10);
        Mockito.when(violation1.getInvalidValue())
                .thenReturn(invalidValue);
        final String message = RandomStringUtils.randomAlphabetic(10);
        Mockito.when(violation1.getMessage())
                .thenReturn(message);
        final MethodValidationException exception = Assertions.assertThrows(MethodValidationException.class, () -> service.validateMethod(model));
        final String expectedExceptionMessage = String.format("Error occurred during method validation, errors: %s", String.format("%s value '%s' %s", pathValue, invalidValue, message));
        assertThat(exception.getMessage(), CoreMatchers.is(expectedExceptionMessage));
    }

    @RequiredArgsConstructor
    private static class ExampleModel implements BaseBotMethodDefinition<Long> {

        private final Long id;

        @Override
        public TypeReference<GenericBotApiResponse<Long>> getResponseClass() {
            return new TypeReference<>() {
            };
        }

        @Override
        public BotMethod getMethod() {
            return null;
        }
    }

}
