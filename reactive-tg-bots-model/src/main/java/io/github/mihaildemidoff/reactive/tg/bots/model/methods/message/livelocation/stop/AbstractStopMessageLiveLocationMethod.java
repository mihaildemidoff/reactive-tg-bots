package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.livelocation.stop;


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
 * Use this method to stop updating a live location message before live_period expires.
 *
 * @see <a href="https://core.telegram.org/bots/api#stopmessagelivelocation">stopMessageLiveLocation</a>
 * @see StopInlineMessageLiveLocationMethod
 * @see StopMessageLiveLocationMethod
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractStopMessageLiveLocationMethod<RESPONSE> implements BaseBotMethodDefinition<RESPONSE> {

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    @Override
    public BotMethod getMethod() {
        return BotMethod.STOP_MESSAGE_LIVE_LOCATION;
    }
}
