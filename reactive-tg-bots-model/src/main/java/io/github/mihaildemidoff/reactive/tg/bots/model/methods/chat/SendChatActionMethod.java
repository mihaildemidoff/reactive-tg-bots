package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method when you need to tell the user that something is happening on the bot's side.
 * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing
 * status). Returns True on success.
 *
 * <b>Example:</b> The ImageBot needs some time to process a request and upload the image. Instead of sending a text
 * message along the lines of “Retrieving image, please wait…”, the bot may use sendChatAction with
 * action = upload_photo. The user will see a “sending photo” status for the bot.
 * <p>
 * We only recommend using this method when a response from the bot will take a noticeable amount of time to arrive.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendchataction">sendChatAction</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendChatActionMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel
     * (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Unique identifier for the target message thread; supergroups only
     */
    @JsonProperty("message_thread_id")
    private final Long messageThreadId;

    /**
     * Type of action to broadcast. Choose one, depending on what the user is about to receive: typing for text
     * messages, upload_photo for photos, record_video or upload_video for videos, record_voice or upload_voice for
     * voice notes, upload_document for general files, choose_sticker for stickers, find_location for location data,
     * record_video_note or upload_video_note for video notes.
     */
    @Valid
    @NotNull
    @JsonProperty("action")
    private final ChatAction action;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SEND_CHAT_ACTION;
    }
}
