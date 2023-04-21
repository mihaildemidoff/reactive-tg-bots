package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.rights;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.ChatAdministratorRights;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to get the current default administrator rights of the bot.
 * Returns {@link ChatAdministratorRights} on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmydefaultadministratorrights">getMyDefaultAdministratorRights</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMyDefaultAdministratorRightsMethod implements TypedBotMethodDefinition<ChatAdministratorRights> {

    /**
     * Pass True to get default administrator rights of the bot in channels.
     * Otherwise, default administrator rights of the bot for groups and supergroups will be returned.
     */
    @JsonProperty("for_channels")
    private final Boolean forChannels;

    @Override
    public TypeReference<GenericBotApiResponse<ChatAdministratorRights>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_MY_DEFAULT_ADMINISTRATOR_RIGHTS;
    }
}
