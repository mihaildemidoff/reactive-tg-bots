package io.github.mihaildemidoff.reactive.tg.bots.model.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * This object represents a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatinvitelink">ChatInviteLink</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chat implements BotApiResponse {

    /**
     * Unique identifier for this chat.
     * This number may have more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it.
     * But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for
     * storing this identifier.
     */
    @NotNull
    @JsonProperty("id")
    private final Long id;

    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     */
    @NotNull
    @JsonProperty("type")
    private final ChatType type;

    /**
     * <b>Optional.</b><br>
     * Title, for supergroups, channels and group chats
     */
    @JsonProperty("title")
    private final String title;

    /**
     * <b>Optional.</b><br>
     * Username, for private chats, supergroups and channels if available
     */
    @JsonProperty("username")
    private final String username;

    /**
     * <b>Optional.</b><br>
     * First name of the other party in a private chat
     */
    @JsonProperty("first_name")
    private final String firstName;

    /**
     * <b>Optional.</b><br>
     * Last name of the other party in a private chat
     */
    @JsonProperty("last_name")
    private final String lastName;

    /**
     * <b>Optional.</b><br>
     * True, if the supergroup chat is a forum (has topics enabled)
     */
    @JsonProperty("is_forum")
    private final Boolean isForum;

    /**
     * <b>Optional.</b><br>
     * Chat photo. Returned only in getChat.
     */
    @Valid
    @JsonProperty("photo")
    private final ChatPhoto photo;

    /**
     * <b>Optional.</b><br>
     * If non-empty, the list of all active chat usernames;
     * for private chats, supergroups and channels. Returned only in getChat.
     */
    @JsonProperty("active_usernames")
    private final List<String> activeUsernames;

    /**
     * <b>Optional.</b><br>
     * Custom emoji identifier of emoji status of the other party in a private chat. Returned only in getChat.
     */
    @JsonProperty("emoji_status_custom_emoji_id")
    private final String emojiStatusCustomEmojiId;

    /**
     * <b>Optional.</b><br>
     * Bio of the other party in a private chat. Returned only in getChat.
     */
    @JsonProperty("bio")
    private final String bio;

    /**
     * <b>Optional.</b><br>
     * True, if privacy settings of the other party in the private chat allows to use tg://user?id=&lt;user_id&gt;
     * links only in chats with the user. Returned only in getChat.
     */
    @JsonProperty("has_private_forwards")
    private final Boolean hasPrivateForwards;

    /**
     * <b>Optional.</b><br>
     * True, if the privacy settings of the other party restrict sending voice and video note messages in the
     * private chat. Returned only in getChat.
     */
    @JsonProperty("has_restricted_voice_and_video_messages")
    private final Boolean hasRestrictedVoiceAndVideoMessages;

    /**
     * <b>Optional.</b><br>
     * True, if users need to join the supergroup before they can send messages. Returned only in getChat.
     */
    @JsonProperty("join_to_send_messages")
    private final Boolean joinToSendMessages;

    /**
     * <b>Optional.</b><br>
     * True, if all users directly joining the supergroup need to be approved by supergroup administrators.
     * Returned only in getChat.
     */
    @JsonProperty("join_by_request")
    private final Boolean joinByRequest;

    /**
     * <b>Optional.</b><br>
     * Description, for groups, supergroups and channel chats. Returned only in getChat.
     */
    @JsonProperty("description")
    private final String description;

    /**
     * <b>Optional.</b><br>
     * Primary invite link, for groups, supergroups and channel chats. Returned only in getChat.
     */
    @JsonProperty("invite_link")
    private final String inviteLink;

    /**
     * <b>Optional.</b><br>
     * The most recent pinned message (by sending date). Returned only in getChat.
     */
    @Valid
    @JsonProperty("pinned_message")
    private final Message pinnedMessage;

    /**
     * <b>Optional.</b><br>
     * Default chat member permissions, for groups and supergroups. Returned only in getChat.
     */
    @Valid
    @JsonProperty("permissions")
    private final ChatPermissions permissions;

    /**
     * <b>Optional.</b><br>
     * For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged
     * user; in seconds. Returned only in getChat.
     */
    @JsonProperty("slow_mode_delay")
    private final Long slowModeDelay;

    /**
     * <b>Optional.</b><br>
     * The time after which all messages sent to the chat will be automatically deleted; in seconds.
     * Returned only in getChat.
     */
    @JsonProperty("message_auto_delete_time")
    private final Long messageAutoDeleteTime;

    /**
     * <b>Optional.</b><br>
     * True, if aggressive anti-spam checks are enabled in the supergroup. The field is only available to chat
     * administrators. Returned only in getChat.
     */
    @JsonProperty("has_aggressive_anti_spam_enabled")
    private final Boolean hasAgressiveAntiSpamEnabled;

    /**
     * <b>Optional.</b><br>
     * True, if non-administrators can only get the list of bots and administrators in the chat.
     * Returned only in getChat.
     */
    @JsonProperty("has_hidden_members")
    private final Boolean hasHiddenMembers;

    /**
     * <b>Optional.</b><br>
     * True, if messages from the chat can't be forwarded to other chats. Returned only in getChat.
     */
    @JsonProperty("has_protected_content")
    private final Boolean hasProtectedContent;

    /**
     * <b>Optional.</b><br>
     * For supergroups, name of group sticker set. Returned only in getChat.
     */
    @JsonProperty("sticker_set_name")
    private final String stickerSetName;

    /**
     * <b>Optional.</b><br>
     * True, if the bot can change the group sticker set. Returned only in getChat.
     */
    @JsonProperty("can_set_sticker_set")
    private final Boolean canSetStickerSet;

    /**
     * <b>Optional.</b><br>
     * Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice
     * versa; for supergroups and channel chats.
     * This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in
     * interpreting it.
     * But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing
     * this identifier. Returned only in getChat.
     */
    @JsonProperty("linked_chat_id")
    private final Long linkedChatId;

    /**
     * <b>Optional.</b><br>
     * For supergroups, the location to which the supergroup is connected. Returned only in getChat.
     */
    @Valid
    @JsonProperty("location")
    private final ChatLocation location;


}
