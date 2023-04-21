package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.invitelink;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.ChatInviteLink;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

/**
 * Use this method to edit a non-primary invite link created by the bot.
 * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights.
 * Returns the edited invite link as a {@link ChatInviteLink} object.
 *
 * @see <a href="https://core.telegram.org/bots/api#editchatinvitelink">editChatInviteLink</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditChatInviteLinkMethod implements TypedBotMethodDefinition<ChatInviteLink> {

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

    /**
     * Invite link name; 0-32 characters
     */
    @Size(max = 32)
    @JsonProperty("name")
    private final String name;

    /**
     * Point in time (Unix timestamp) when the link will expire
     */
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("expire_date")
    private final Instant expireDate;

    /**
     * The maximum number of users that can be members of the chat simultaneously after joining the chat via this
     * invite link; 1-99999
     */
    @Max(99999)
    @Min(1)
    @JsonProperty("member_limit")
    private final Long memberLimit;

    /**
     * True, if users joining the chat via the link need to be approved by chat administrators.
     * If True, member_limit can't be specified
     */
    @JsonProperty("creates_join_request")
    private final Boolean createsJoinRequest;

    @Override
    public TypeReference<GenericBotApiResponse<ChatInviteLink>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.EDIT_CHAT_INVITE_LINK;
    }
}
