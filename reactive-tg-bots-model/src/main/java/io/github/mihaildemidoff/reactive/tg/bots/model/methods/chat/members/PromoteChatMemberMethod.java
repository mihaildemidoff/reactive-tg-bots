package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.members;


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
 * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the
 * chat for this to work and must have the appropriate administrator rights. Pass False for all boolean parameters to
 * demote a user. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#promotechatmember">promoteChatMember</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromoteChatMemberMethod implements BooleanBotMethodDefinition {

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

    /**
     * Pass True if the administrator's presence in the chat is hidden
     */
    @NotNull
    @JsonProperty("is_anonymous")
    private final Boolean isAnonymous;

    /**
     * Pass True if the administrator can access the chat event log, chat statistics, message statistics in channels,
     * see channel members, see anonymous administrators in supergroups and ignore slow mode.
     * Implied by any other administrator privilege
     */
    @NotNull
    @JsonProperty("can_manage_chat")
    private final Boolean canManagerChat;

    /**
     * Pass True if the administrator can create channel posts, channels only
     */
    @JsonProperty("can_post_messages")
    private final Boolean canPostMessages;

    /**
     * Pass True if the administrator can edit messages of other users and can pin messages, channels only
     */
    @JsonProperty("can_edit_messages")
    private final Boolean canEditMessages;

    /**
     * True, if the administrator can delete messages of other users
     */
    @NotNull
    @JsonProperty("can_delete_messages")
    private final Boolean canDeleteMessages;

    /**
     * Pass True if the administrator can manage video chats
     */
    @NotNull
    @JsonProperty("can_manage_video_chats")
    private final Boolean canManageVideoChats;

    /**
     * Pass True if the administrator can restrict, ban or unban chat members
     */
    @NotNull
    @JsonProperty("can_restrict_members")
    private final Boolean canRestrictMembers;

    /**
     * Pass True if the administrator can add new administrators with a subset of their own privileges or demote
     * administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed
     * by him)
     */
    @NotNull
    @JsonProperty("can_promote_members")
    private final Boolean canPromoteMembers;

    /**
     * Pass True if the administrator can change chat title, photo and other settings
     */
    @NotNull
    @JsonProperty("can_change_info")
    private final Boolean canChangeInfo;

    /**
     * Pass True if the administrator can invite new users to the chat
     */
    @NotNull
    @JsonProperty("can_invite_users")
    private final Boolean canInviteUsers;


    /**
     * Pass True if the administrator can pin messages, supergroups only
     */
    @JsonProperty("can_pin_messages")
    private final Boolean canPinMessages;

    /**
     * Pass True if the user is allowed to create, rename, close, and reopen forum topics, supergroups only
     */
    @JsonProperty("can_manage_topics")
    private final Boolean canManageTopics;


    @Override
    public BotMethod getMethod() {
        return BotMethod.PROMOTE_CHAT_MEMBER;
    }
}
