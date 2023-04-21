package io.github.mihaildemidoff.reactive.tg.bots.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.location.Location;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.ChatType;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents an incoming inline query.
 * When the user sends an empty query, your bot could return some default or trending results.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequery">InlineQuery</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQuery {

    /**
     * Unique identifier for this query
     */
    @NotNull
    @JsonProperty("id")
    private final String id;

    /**
     * Sender
     */
    @Valid
    @NotNull
    @JsonProperty("from")
    private final User from;

    /**
     * Text of the query (up to 256 characters)
     */
    @Size(max = 256)
    @NotNull
    @JsonProperty("query")
    private final String query;

    /**
     * Offset of the results to be returned, can be controlled by the bot
     */
    @NotNull
    @JsonProperty("offset")
    private final String offset;

    /**
     * <b>Optional.</b><br>
     * Type of the chat from which the inline query was sent.
     * Can be either “sender” for a private chat with the inline query sender, “private”, “group”, “supergroup”, or
     * “channel”. The chat type should be always known for requests sent from official clients and most third-party
     * clients, unless the request was sent from a secret chat
     */
    @JsonProperty("chat_type")
    private final ChatType chatType;

    /**
     * <b>Optional.</b><br>
     * Sender location, only for bots that request user location
     */
    @Valid
    @JsonProperty("location")
    private final Location location;
}

