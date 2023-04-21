package io.github.mihaildemidoff.reactive.tg.bots.model.methods.games;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to send a game.
 * On success, the sent {@link Message} is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendgame">sendGame</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendGameMethod implements TypedBotMethodDefinition<Message> {

    /**
     * Unique identifier for the target chat
     */
    @NotNull
    @JsonProperty("chat_id")
    private final Long chatId;

    /**
     * Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     */
    @JsonProperty("message_thread_id")
    private final Long messageThreadId;

    /**
     * Short name of the game, serves as the unique identifier for the game. Set up your games via @BotFather.
     */
    @NotNull
    @JsonProperty("game_short_name")
    private final String gameShortName;

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @JsonProperty("disable_notification")
    private final Boolean disableNotification;

    /**
     * Protects the contents of the sent message from forwarding and saving
     */
    @JsonProperty("protect_content")
    private final Boolean protectContent;

    /**
     * If the message is a reply, ID of the original message
     */
    @JsonProperty("reply_to_message_id")
    private final Long replyToMessageId;

    /**
     * Pass True if the message should be sent even if the specified replied-to message is not found
     */
    @JsonProperty("allow_sending_without_reply")
    private final Boolean allowSendingWithoutReply;

    /**
     * A JSON-serialized object for an inline keyboard. If empty, one 'Play game_title' button will be shown.
     * If not empty, the first button must launch the game.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    @Override
    public TypeReference<GenericBotApiResponse<Message>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.SEND_GAME;
    }
}
