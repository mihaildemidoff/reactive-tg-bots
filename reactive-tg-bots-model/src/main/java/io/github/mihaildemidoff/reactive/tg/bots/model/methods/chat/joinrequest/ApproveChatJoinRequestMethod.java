package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.joinrequest;


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
 * Use this method to approve a chat join request. The bot must be an administrator in the chat for this to work and
 * must have the can_invite_users administrator right.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#approvechatjoinrequest">approveChatJoinRequest</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApproveChatJoinRequestMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Unique identifier of the target user
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    @Override
    public BotMethod getMethod() {
        return BotMethod.APPROVE_CHAT_JOIN_REQUEST;
    }
}
