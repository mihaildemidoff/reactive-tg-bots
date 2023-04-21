package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.replymarkup;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Use this method to edit only the reply markup of messages.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagereplymarkup">editMessageReplyMarkup</a>
 * @see EditMessageReplyMarkupMethod
 * @see EditInlineMessageReplyMarkupMethod
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEditMessageReplyMarkupMethod<RESPONSE> implements BaseBotMethodDefinition<RESPONSE> {

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    @Override
    public BotMethod getMethod() {
        return BotMethod.EDIT_MESSAGE_REPLY_MARKUP;
    }
}
