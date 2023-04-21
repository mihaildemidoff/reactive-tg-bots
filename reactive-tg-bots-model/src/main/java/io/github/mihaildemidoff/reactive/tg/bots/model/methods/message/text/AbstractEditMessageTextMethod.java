package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.text;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Use this method to edit text and game messages.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagetext">editMessageText</a>
 * @see EditInlineMessageTextMethod
 * @see EditMessageTextMethod
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEditMessageTextMethod<RESPONSE> implements BaseBotMethodDefinition<RESPONSE> {

    /**
     * New text of the message, 1-4096 characters after entities parsing
     */
    @NotNull
    @JsonProperty("text")
    private final String text;

    /**
     * Mode for parsing entities in the message text. See formatting options for more details.
     */
    @JsonProperty("parse_mode")
    private final ParseMode parseMode;

    /**
     * A JSON-serialized list of special entities that appear in message text, which can be specified instead of
     * parse_mode
     */
    @Valid
    @JsonProperty("entities")
    private final List<MessageEntity> entities;

    /**
     * Disables link previews for links in this message
     */
    @JsonProperty("disable_web_page_preview")
    private final Boolean disableWebPagePreview;

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    @Override
    public BotMethod getMethod() {
        return BotMethod.EDIT_MESSAGE_TEXT;
    }
}
