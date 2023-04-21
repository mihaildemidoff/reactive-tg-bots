package io.github.mihaildemidoff.reactive.tg.bots.model.inline.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputtextmessagecontent">InputTextMessageContent</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputTextMessageContent implements InputMessageContent {

    /**
     * Text of the message to be sent, 1-4096 characters
     */
    @Size(min = 1, max = 4096)
    @NotNull
    @JsonProperty("message_text")
    private final String messageText;

    /**
     * <b>Optional.</b><br>
     * Mode for parsing entities in the message text. See formatting options for more details.
     */
    @JsonProperty("parse_mode")
    private final ParseMode parseMode;

    /**
     * <b>Optional.</b><br>
     * List of special entities that appear in message text, which can be specified instead of parse_mode
     */
    @Valid
    @NotNull
    @JsonProperty("entities")
    private final List<MessageEntity> entities;

    /**
     * <b>Optional.</b><br>
     * Disables link previews for links in the sent message
     */
    @NotNull
    @JsonProperty("disable_web_page_preview")
    private final Boolean disableWebPagePreview;

}
