package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.rights;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.ChatAdministratorRights;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to change the default administrator rights requested by the bot when it's added as an administrator
 * to groups or channels. These rights will be suggested to users, but they are free to modify the list before adding
 * the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmydefaultadministratorrights">setMyDefaultAdministratorRights</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetMyDefaultAdministratorRightsMethod implements BooleanBotMethodDefinition {

    /**
     * A JSON-serialized object describing new default administrator rights. If not specified, the default administrator
     * rights will be cleared.
     */
    @Valid
    @JsonProperty("rights")
    private final ChatAdministratorRights rights;

    /**
     * Pass True to change the default administrator rights of the bot in channels. Otherwise, the default
     * administrator rights of the bot for groups and supergroups will be changed.
     */
    @JsonProperty("for_channels")
    private final Boolean forChannels;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_MY_DEFAULT_ADMINISTRATOR_RIGHTS;
    }
}
