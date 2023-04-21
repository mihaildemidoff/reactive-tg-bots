package io.github.mihaildemidoff.reactive.tg.bots.model.chat.member;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

/**
 * Represents a chat member that is under certain restrictions in the chat. Supergroups only.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberrestricted">ChatMemberRestricted</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMemberRestricted extends ChatMember {

    /**
     * The member's status in the chat, always “restricted”
     */
    @NotNull
    @JsonProperty("status")
    private final ChatMemberStatus status = ChatMemberStatus.RESTRICTED;

    /**
     * True, if the user is a member of the chat at the moment of the request
     */
    @NotNull
    @JsonProperty("is_member")
    private final Boolean isMember;

    /**
     * True, if the user is allowed to send text messages, contacts, invoices, locations and venues
     */
    @NotNull
    @JsonProperty("can_send_messages")
    private final Boolean canSendMessages;

    /**
     * True, if the user is allowed to send audios
     */
    @NotNull
    @JsonProperty("can_send_audios")
    private final Boolean canSendAudios;

    /**
     * True, if the user is allowed to send documents
     */
    @NotNull
    @JsonProperty("can_send_documents")
    private final Boolean canSendDocuments;

    /**
     * True, if the user is allowed to send photos
     */
    @NotNull
    @JsonProperty("can_send_photos")
    private final Boolean canSendPhotos;

    /**
     * True, if the user is allowed to send videos
     */
    @NotNull
    @JsonProperty("can_send_videos")
    private final Boolean canSendVideos;

    /**
     * True, if the user is allowed to send video notes
     */
    @NotNull
    @JsonProperty("can_send_video_notes")
    private final Boolean canSendVideoNotes;

    /**
     * True, if the user is allowed to send voice notes
     */
    @NotNull
    @JsonProperty("can_send_voice_notes")
    private final Boolean canSendVoiceNotes;

    /**
     * True, if the user is allowed to send polls
     */
    @NotNull
    @JsonProperty("can_send_polls")
    private final Boolean canSendPolls;

    /**
     * True, if the user is allowed to send animations, games, stickers and use inline bots
     */
    @NotNull
    @JsonProperty("can_send_other_messages")
    private final Boolean canSendOtherMessages;

    /**
     * True, if the user is allowed to add web page previews to their messages
     */
    @NotNull
    @JsonProperty("can_add_web_page_previews")
    private final Boolean canAddWebPagePreviews;

    /**
     * True, if the user is allowed to change the chat title, photo and other settings
     */
    @NotNull
    @JsonProperty("True, if the user is allowed to add web page previews to their messages")
    private final Boolean canChangeInfo;

    /**
     * True, if the user is allowed to invite new users to the chat
     */
    @NotNull
    @JsonProperty("can_invite_users")
    private final Boolean canInviteUsers;

    /**
     * True, if the user is allowed to pin messages
     */
    @NotNull
    @JsonProperty("can_pin_messages")
    private final Boolean canPinMessages;

    /**
     * True, if the user is allowed to create forum topics
     */
    @NotNull
    @JsonProperty("can_manage_topics")
    private final Boolean canManageTopics;

    /**
     * Date when restrictions will be lifted for this user; unix time.
     * If 0, then the user is restricted forever. Check instant seconds
     */
    @NotNull
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("until_date")
    private final Instant untilDate;


}
