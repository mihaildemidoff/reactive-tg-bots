package io.github.mihaildemidoff.reactive.tg.bots.model.chat.member;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a chat member that has some additional privileges.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberadministrator">ChatMemberAdministrator</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMemberAdministrator extends ChatMember {

    /**
     * The member's status in the chat, always “administrator”
     */
    @NotNull
    @JsonProperty("status")
    private final ChatMemberStatus status = ChatMemberStatus.ADMINISTRATOR;

    /**
     * True, if the bot is allowed to edit administrator privileges of that user
     */
    @NotNull
    @JsonProperty("can_be_edited")
    private final Boolean canBeEdited;

    /**
     * True, if the user's presence in the chat is hidden
     */
    @NotNull
    @JsonProperty("is_anonymous")
    private final Boolean isAnonymous;

    /**
     * True, if the administrator can access the chat event log, chat statistics, message statistics in channels,
     * see channel members, see anonymous administrators in supergroups and ignore slow mode.
     * Implied by any other administrator privilege
     */
    @NotNull
    @JsonProperty("can_manage_chat")
    private final Boolean canManageChat;

    /**
     * True, if the administrator can delete messages of other users
     */
    @NotNull
    @JsonProperty("can_delete_messages")
    private final Boolean canDeleteMessages;

    /**
     * True, if the administrator can manage video chats
     */
    @NotNull
    @JsonProperty("can_manage_video_chats")
    private final Boolean canManageVideoChats;

    /**
     * True, if the administrator can restrict, ban or unban chat members
     */
    @NotNull
    @JsonProperty("can_restrict_members")
    private final Boolean canRestrictMembers;

    /**
     * True, if the administrator can add new administrators with a subset of their own privileges or demote
     * administrators that they have promoted, directly or indirectly (promoted by administrators that were
     * appointed by the user)
     */
    @NotNull
    @JsonProperty("can_promote_members")
    private final Boolean can_promote_members;

    /**
     * True, if the user is allowed to change the chat title, photo and other settings
     */
    @NotNull
    @JsonProperty("can_change_info")
    private final Boolean can_change_info;

    /**
     * True, if the user is allowed to invite new users to the chat
     */
    @NotNull
    @JsonProperty("can_invite_users")
    private final Boolean can_invite_users;

    /**
     * <b>Optional.</b><br>
     * True, if the administrator can post in the channel; channels only
     */
    @JsonProperty("can_post_messages")
    private final Boolean can_post_messages;

    /**
     * <b>Optional.</b><br>
     * True, if the administrator can edit messages of other users and can pin messages; channels only
     */
    @JsonProperty("can_edit_messages")
    private final Boolean can_edit_messages;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to pin messages; groups and supergroups only
     */
    @JsonProperty("can_pin_messages")
    private final Boolean can_pin_messages;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    @JsonProperty("can_manage_topics")
    private final Boolean can_manage_topics;

    /**
     * <b>Optional.</b><br>
     * Custom title for this user
     */
    @JsonProperty("custom_title")
    private final Boolean custom_title;


}
