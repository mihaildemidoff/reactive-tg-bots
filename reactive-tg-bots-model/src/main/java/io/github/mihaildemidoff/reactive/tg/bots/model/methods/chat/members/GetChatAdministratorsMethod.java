package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.members;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.member.ChatMember;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.ListBotMethodDefinition;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to get a list of administrators in a chat, which aren't bots.
 * Returns an Array of {@link ChatMember} objects.
 *
 * @see <a href="https://core.telegram.org/bots/api#getchatadministrators">getChatAdministrators</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChatAdministratorsMethod implements ListBotMethodDefinition<ChatMember> {

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel
     * (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    @Override
    public TypeReference<GenericBotApiResponse<List<ChatMember>>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_CHAT_ADMINISTRATORS;
    }
}
