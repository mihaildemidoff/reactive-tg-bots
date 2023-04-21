package io.github.mihaildemidoff.reactive.tg.bots.model.methods.passport;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors.PassportElementError;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Informs a user that some of the Telegram Passport elements they provided contains errors.
 * The user will not be able to re-submit their Passport to you until the errors are fixed
 * (the contents of the field for which you returned the error must change). Returns True on success.
 * <p>
 * Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason.
 * For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering,
 * etc. Supply some details in the error message to make sure the user knows how to correct the issues.
 *
 * @see <a href="https://core.telegram.org/bots/api#setpassportdataerrors">setPassportDataErrors</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetPassportDataErrorsMethod implements BooleanBotMethodDefinition {

    /**
     * User identifier
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * A JSON-serialized array describing the errors
     */
    @Valid
    @NotNull
    @NotEmpty
    @JsonProperty("errors")
    private final List<PassportElementError> errors;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_PASSPORT_DATA_ERRORS;
    }
}
