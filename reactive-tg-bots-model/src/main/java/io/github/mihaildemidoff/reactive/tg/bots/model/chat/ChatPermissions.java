package io.github.mihaildemidoff.reactive.tg.bots.model.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatpermissions">ChatPermissions</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatPermissions {
    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send text messages, contacts, invoices, locations and venues
     */
    @JsonProperty("can_send_messages")
    private final Boolean canSendMessages;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send audios
     */
    @JsonProperty("can_send_audios")
    private final Boolean canSendAudios;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send documents
     */
    @JsonProperty("can_send_documents")
    private final Boolean canSendDocuments;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send photos
     */
    @JsonProperty("can_send_photos")
    private final Boolean canSendPhotos;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send videos
     */
    @JsonProperty("can_send_videos")
    private final Boolean canSendVideos;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send video notes
     */
    @JsonProperty("can_send_video_notes")
    private final Boolean canSendVideoNotes;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send voice notes
     */
    @JsonProperty("can_send_voice_notes")
    private final Boolean canSendVoiceNotes;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send polls
     */
    @JsonProperty("can_send_polls")
    private final Boolean canSendPolls;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to send animations, games, stickers and use inline bots
     */
    @JsonProperty("can_send_other_messages")
    private final Boolean canSendOtherMessages;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to add web page previews to their messages
     */
    @JsonProperty("can_add_web_page_previews")
    private final Boolean canAddWebPagePreviews;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to change the chat title, photo and other settings.
     * Ignored in public supergroups
     */
    @JsonProperty("can_change_info")
    private final Boolean canChangeInfo;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to invite new users to the chat
     */
    @JsonProperty("can_invite_users")
    private final Boolean canInviteUsers;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to pin messages. Ignored in public supergroups
     */
    @JsonProperty("can_pin_messages")
    private final Boolean canPinMessages;

    /**
     * <b>Optional.</b><br>
     * True, if the user is allowed to create forum topics.
     * If omitted defaults to the value of can_pin_messages
     */
    @JsonProperty("can_manage_topics")
    private final Boolean canManageTopics;
}
