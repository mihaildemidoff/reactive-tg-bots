package io.github.mihaildemidoff.reactive.tg.bots.model.validation;

import io.github.mihaildemidoff.reactive.tg.bots.model.passport.EncryptedPassportElementType;
import io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors.PassportElementErrorSectionType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class PassportElementErrorSectionTypeSubsetValidatorTest {

    @InjectMocks
    private PassportElementErrorSectionTypeSubsetValidator validator;

    @ParameterizedTest
    @MethodSource("testData")
    void testValidation(final List<PassportElementErrorSectionType> subset,
                        final PassportElementErrorSectionType value,
                        final boolean expectedResult) {
        final PassportElementErrorSectionTypeSubset annotation
                = Mockito.mock(PassportElementErrorSectionTypeSubset.class);
        Mockito.when(annotation.anyOf())
                .thenReturn(subset.toArray(PassportElementErrorSectionType[]::new));
        validator.initialize(annotation);
        assertThat(validator.isValid(value, null), CoreMatchers.is(expectedResult));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(), PassportElementErrorSectionType.PASSPORT, false),
                Arguments.of(List.of(PassportElementErrorSectionType.PASSPORT), PassportElementErrorSectionType.PASSPORT, true),
                Arguments.of(List.of(PassportElementErrorSectionType.PASSPORT, PassportElementErrorSectionType.INTERNAL_PASSPORT), PassportElementErrorSectionType.PASSPORT, true),
                Arguments.of(List.of(PassportElementErrorSectionType.PASSPORT, PassportElementErrorSectionType.INTERNAL_PASSPORT), PassportElementErrorSectionType.IDENTITY_CARD, false),
                Arguments.of(List.of(PassportElementErrorSectionType.PASSPORT, PassportElementErrorSectionType.INTERNAL_PASSPORT), null, true),
                Arguments.of(List.of(), null, true)
        );
    }

}
