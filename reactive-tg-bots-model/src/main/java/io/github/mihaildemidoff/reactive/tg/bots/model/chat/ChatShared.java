package io.github.mihaildemidoff.reactive.tg.bots.model.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object contains information about the chat whose identifier was shared with the bot using a
 * KeyboardButtonRequestChat button.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatshared">ChatShared</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatShared {

    /**
     * Identifier of the request
     */
    @NotNull
    @JsonProperty("request_id")
    private final Long requestId;

    /**
     * Identifier of the shared chat. This number may have more than 32 significant bits and some programming languages
     * may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit
     * integer or double-precision float type are safe for storing this identifier. The bot may not have access to the
     * chat and could be unable to use this identifier, unless the chat is already known to the bot by some other means.
     */
    @NotNull
    @JsonProperty("chat_id")
    private final Long chatId;
}
