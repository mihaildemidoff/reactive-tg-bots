package io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * The section of the user's Telegram Passport.
 */
@RequiredArgsConstructor
public enum PassportElementErrorSectionType {

    /**
     * personal_details.
     */
    PERSONAL_DETAILS("personal_details"),

    /**
     * passport.
     */
    PASSPORT("passport"),

    /**
     * driver_license.
     */
    DRIVER_LICENSE("driver_license"),

    /**
     * identity_card.
     */
    IDENTITY_CARD("identity_card"),

    /**
     * internal_passport.
     */
    INTERNAL_PASSPORT("internal_passport"),

    /**
     * address.
     */
    ADDRESS("address"),

    /**
     * utility_bill
     */
    UTILITY_BILL("utility_bill"),

    /**
     * bank_statement
     */
    BANK_STATEMENT("bank_statement"),

    /**
     * rental_agreement
     */
    RENTAL_AGREEMENT("rental_agreement"),

    /**
     * passport_registration
     */
    PASSPORT_REGISTRATION("passport_registration"),

    /**
     * temporary_registration
     */
    TEMPORARY_REGISTRATION("temporary_registration");

    /**
     * String value of enum
     */
    private final String value;

    /**
     * Returns string representation of enum.
     *
     * @return string value of enum
     */
    @JsonValue
    public String toValue() {
        return value;
    }

    /**
     * Finds enum value for provided string.
     *
     * @param source string representation of enum
     * @return found enum or null if enum not found
     */
    @JsonCreator
    public static PassportElementErrorSectionType fromValue(final String source) {
        return Stream.of(PassportElementErrorSectionType.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
