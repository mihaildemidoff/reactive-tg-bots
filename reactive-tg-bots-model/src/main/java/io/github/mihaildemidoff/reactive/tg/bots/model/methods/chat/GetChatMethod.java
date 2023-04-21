package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.Chat;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to get up to date information about the chat (current name of the user for one-on-one conversations,
 * current username of a user, group or channel, etc.).
 * Returns a {@link io.github.mihaildemidoff.reactive.tg.bots.model.chat.Chat} object on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getchat">getChat</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChatMethod implements TypedBotMethodDefinition<Chat> {

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel
     * (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    @Override
    public TypeReference<GenericBotApiResponse<Chat>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_CHAT;
    }
}
