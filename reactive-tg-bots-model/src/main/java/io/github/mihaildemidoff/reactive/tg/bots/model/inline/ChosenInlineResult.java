package io.github.mihaildemidoff.reactive.tg.bots.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.location.Location;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a result of an inline query that was chosen by the user and sent to their chat partner.
 * <b>Note:</b> It is necessary to enable inline feedback via @BotFather in order to receive these objects in updates.
 *
 * @see <a href="https://core.telegram.org/bots/api#choseninlineresult">ChosenInlineResult</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChosenInlineResult {

    /**
     * The unique identifier for the result that was chosen
     */
    @NotNull
    @JsonProperty("result_id")
    private final String resultId;

    /**
     * The user that chose the result
     */
    @Valid
    @NotNull
    @JsonProperty("from")
    private final User from;

    /**
     * <b>Optional.</b><br>
     * Sender location, only for bots that require user location
     */
    @Valid
    @JsonProperty("location")
    private final Location location;

    /**
     * <b>Optional.</b><br>
     * Identifier of the sent inline message.
     * Available only if there is an inline keyboard attached to the message.
     * Will be also received in callback queries and can be used to edit the message.
     */
    @JsonProperty("inline_message_id")
    private final String inlineMessageId;

    /**
     * The query that was used to obtain the result
     */
    @NotNull
    @JsonProperty("query")
    private final String query;
}
