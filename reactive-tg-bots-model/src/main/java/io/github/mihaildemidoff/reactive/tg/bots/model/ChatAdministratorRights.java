package io.github.mihaildemidoff.reactive.tg.bots.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the rights of an administrator in a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatadministratorrights">ChatAdministratorRights</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatAdministratorRights implements BotApiResponse {

    /**
     * True, if the user's presence in the chat is hidden
     */
    @NotNull
    @JsonProperty("is_anonymous")
    private final Boolean isAnonymous;

    /**
     * True, if the administrator can access the chat event log, chat statistics, message statistics in channels, see
     * channel members, see anonymous administrators in supergroups and ignore slow mode.
     * Implied by any other administrator privilege
     */
    @NotNull
    @JsonProperty("can_manage_chat")
    private final Boolean canManagerChat;

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
     * administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed
     * by the user)
     */
    @NotNull
    @JsonProperty("can_promote_members")
    private final Boolean canPromoteMembers;

    /**
     * True, if the user is allowed to change the chat title, photo and other settings
     */
    @NotNull
    @JsonProperty("can_change_info")
    private final Boolean canChangeInfo;

    /**
     * True, if the user is allowed to invite new users to the chat
     */
    @NotNull
    @JsonProperty("can_invite_users")
    private final Boolean canInviteUsers;

    /**
     * <b>Optional.</b><br>
     * True, if the administrator can post in the channel; channels only
     */
    @JsonProperty("can_post_messages")
    private final Boolean canPostMessages;

    /**
     * <b>Optional.</b><br>
     * True, if the administrator can edit messages of other users and can pin messages; channels only
     */
    @JsonProperty("can_edit_messages")
    private final Boolean canEditMessages;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to pin messages; groups and supergroups only
     */
    @JsonProperty("can_pin_messages")
    private final Boolean canPinMessages;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    @JsonProperty("can_manage_topics")
    private final Boolean canManageTopics;

}
