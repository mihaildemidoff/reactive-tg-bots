package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.caption;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Use this method to edit captions of messages.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagecaption">editMessageCaption</a>
 * @see EditInlineMessageCaptionMethod
 * @see EditMessageCaptionMethod
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEditMessageCaptionMethod<RESPONSE> implements BaseBotMethodDefinition<RESPONSE> {

    /**
     * New caption of the message, 0-1024 characters after entities parsing
     */
    @JsonProperty("caption")
    private final String caption;

    /**
     * Mode for parsing entities in the message caption. See formatting options for more details.
     */
    @JsonProperty("parse_mode")
    private final ParseMode parseMode;

    /**
     * A JSON-serialized list of special entities that appear in the caption, which can be specified instead
     * of parse_mode
     */
    @Valid
    @JsonProperty("caption_entities")
    private final List<MessageEntity> captionEntities;

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    @Override
    public BotMethod getMethod() {
        return BotMethod.EDIT_MESSAGE_CAPTION;
    }
}
