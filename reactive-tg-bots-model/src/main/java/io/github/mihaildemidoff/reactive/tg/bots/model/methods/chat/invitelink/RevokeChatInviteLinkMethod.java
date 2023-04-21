package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.invitelink;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.ChatInviteLink;
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
 * Use this method to revoke an invite link created by the bot.
 * If the primary link is revoked, a new link is automatically generated.
 * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights.
 * Returns the revoked invite link as
 * {@link ChatInviteLink} object.
 *
 * @see <a href="https://core.telegram.org/bots/api#revokechatinvitelink">revokeChatInviteLink</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class RevokeChatInviteLinkMethod implements TypedBotMethodDefinition<ChatInviteLink> {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * The invite link to edit
     */
    @NotNull
    @JsonProperty("invite_link")
    private final String inviteLink;

    @Override
    public TypeReference<GenericBotApiResponse<ChatInviteLink>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.REVOKE_CHAT_INVITE_LINK;
    }
}
