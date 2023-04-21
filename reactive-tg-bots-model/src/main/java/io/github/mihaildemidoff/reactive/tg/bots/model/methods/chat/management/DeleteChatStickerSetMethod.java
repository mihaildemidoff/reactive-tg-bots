package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.management;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for
 * this to work and must have the appropriate administrator rights. Use the field can_set_sticker_set optionally
 * returned in getChat requests to check if the bot can use this method.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletechatstickerset">deleteChatStickerSet</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteChatStickerSetMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;


    @Override
    public BotMethod getMethod() {
        return BotMethod.DELETE_CHAT_STICKER_SET;
    }
}
