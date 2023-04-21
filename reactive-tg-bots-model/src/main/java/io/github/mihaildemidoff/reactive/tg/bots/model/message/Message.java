package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.location.Location;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.Chat;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.ChatShared;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.Animation;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.Audio;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.Document;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.PhotoSize;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.Video;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.VideoNote;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.Voice;
import io.github.mihaildemidoff.reactive.tg.bots.model.forum.ForumTopicClosed;
import io.github.mihaildemidoff.reactive.tg.bots.model.forum.ForumTopicCreated;
import io.github.mihaildemidoff.reactive.tg.bots.model.forum.ForumTopicEdited;
import io.github.mihaildemidoff.reactive.tg.bots.model.forum.ForumTopicReopened;
import io.github.mihaildemidoff.reactive.tg.bots.model.forum.GeneralForumTopicHidden;
import io.github.mihaildemidoff.reactive.tg.bots.model.forum.GeneralForumTopicUnhidden;
import io.github.mihaildemidoff.reactive.tg.bots.model.games.Game;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.passport.PassportData;
import io.github.mihaildemidoff.reactive.tg.bots.model.payments.Invoice;
import io.github.mihaildemidoff.reactive.tg.bots.model.payments.SuccessfulPayment;
import io.github.mihaildemidoff.reactive.tg.bots.model.poll.Poll;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.Sticker;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.Contact;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.UserShared;
import io.github.mihaildemidoff.reactive.tg.bots.model.videochat.VideoChatEnded;
import io.github.mihaildemidoff.reactive.tg.bots.model.videochat.VideoChatParticipantsInvited;
import io.github.mihaildemidoff.reactive.tg.bots.model.videochat.VideoChatScheduled;
import io.github.mihaildemidoff.reactive.tg.bots.model.videochat.VideoChatStarted;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.List;

/**
 * This object represents a message.
 *
 * @see <a href="https://core.telegram.org/bots/api#message">Message</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements BotApiResponse {

    /**
     * Unique message identifier inside this chat
     */
    @NotNull
    @JsonProperty("message_id")
    private final Long messageId;

    /**
     * <b>Optional.</b><br>
     * <p>
     * Unique identifier of a message thread or a forum topic to which the message belongs;
     * for supergroups only
     */
    @JsonProperty("message_thread_id")
    private final Long messageThreadId;

    /**
     * <b>Optional.</b><br>
     * Sender of the message; empty for messages sent to channels.
     * For backward compatibility, the field contains a fake sender user in non-channel chats, if the message was sent
     * on behalf of a chat.
     */
    @Valid
    @JsonProperty("from")
    private final User from;

    /**
     * <b>Optional.</b><br>
     * Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts,
     * the supergroup itself for messages from anonymous group administrators, the linked channel for messages
     * automatically forwarded to the discussion group. For backward compatibility, the field from contains a fake
     * sender user in non-channel chats, if the message was sent on behalf of a chat.
     */
    @Valid
    @JsonProperty("sender_chat")
    private final Chat senderChat;

    /**
     * Date the message was sent in Unix time
     */
    @NotNull
    @JsonProperty("date")
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    private final Instant date;

    /**
     * Conversation the message belongs to
     */
    @Valid
    @NotNull
    @JsonProperty("chat")
    private final Chat chat;

    /**
     * <b>Optional.</b><br>
     * For forwarded messages, sender of the original message
     */
    @Valid
    @JsonProperty("forward_from")
    private final User forwardFrom;

    /**
     * <b>Optional.</b><br>
     * For messages forwarded from channels or from anonymous administrators, information about the original
     * sender chat
     */
    @Valid
    @JsonProperty("forward_from_chat")
    private final Chat forwardFromChat;

    /**
     * <b>Optional.</b><br>
     * For messages forwarded from channels, identifier of the original message in the channel
     */
    @JsonProperty("forward_from_message_id")
    private final Long forwardFromMessageId;

    /**
     * <b>Optional.</b><br>
     * For forwarded messages that were originally sent in channels or by an anonymous chat administrator,
     * signature of the message sender if present
     */
    @JsonProperty("forward_signature")
    private final String forwardSignature;

    /**
     * <b>Optional.</b><br>
     * Sender's name for messages forwarded from users who disallow adding a link to their account in
     * forwarded messages
     */
    @JsonProperty("forward_sender_name")
    private final String forwardSenderName;

    /**
     * <b>Optional.</b><br>
     * For forwarded messages, date the original message was sent in Unix time
     */
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("forward_date")
    private final Instant forwardDate;

    /**
     * <b>Optional.</b><br>
     * True, if the message is sent to a forum topic
     */
    @JsonProperty("is_topic_message")
    private final Boolean isTopicMessage;

    /**
     * <b>Optional.</b><br>
     * True, if the message is a channel post that was automatically forwarded to the connected discussion
     * group
     */
    @JsonProperty("is_automatic_forward")
    private final Boolean isAutomaticForward;

    /**
     * <b>Optional.</b><br>
     * For replies, the original message. Note that the Message object in this field will not contain further
     * reply_to_message fields even if it itself is a reply.
     */
    @Valid
    @JsonProperty("reply_to_message")
    private final Message replyToMessage;

    /**
     * <b>Optional.</b><br>
     * Bot through which the message was sent
     */
    @Valid
    @JsonProperty("via_bot")
    private final User viaBot;

    /**
     * <b>Optional.</b><br>
     * Date the message was last edited in Unix time
     */
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("edit_date")
    private final Instant editDate;

    /**
     * <b>Optional.</b><br>
     * True, if the message can't be forwarded
     */
    @JsonProperty("has_protected_content")
    private final Boolean hasProtectedContent;

    /**
     * <b>Optional.</b><br>
     * The unique identifier of a media message group this message belongs to
     */
    @JsonProperty("media_group_id")
    private final String mediaGroupId;

    /**
     * <b>Optional.</b><br>
     * Signature of the post author for messages in channels, or the custom title of an anonymous group
     * administrator
     */
    @JsonProperty("author_signature")
    private final String authorSignature;

    /**
     * <b>Optional.</b><br>
     * For text messages, the actual UTF-8 text of the message
     */
    @JsonProperty("text")
    private final String text;

    /**
     * <b>Optional.</b><br>
     * For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
     */
    @Valid
    @JsonProperty("entities")
    private final List<MessageEntity> entities;

    /**
     * <b>Optional.</b><br>
     * Message is an animation, information about the animation. For backward compatibility, when this field
     * is set, the document field will also be set
     */
    @Valid
    @JsonProperty("animation")
    private final Animation animation;

    /**
     * <b>Optional.</b><br>
     * Message is an audio file, information about the file
     */
    @Valid
    @JsonProperty("audio")
    private final Audio audio;

    /**
     * <b>Optional.</b><br>
     * Message is a general file, information about the file
     */
    @Valid
    @JsonProperty("document")
    private final Document document;

    /**
     * <b>Optional.</b><br>
     * Message is a photo, available sizes of the photo
     */
    @Valid
    @JsonProperty("photo")
    private final List<PhotoSize> photo;

    /**
     * <b>Optional.</b><br>
     * Message is a sticker, information about the sticker
     */
    @Valid
    @JsonProperty("sticker")
    private final Sticker sticker;

    /**
     * <b>Optional.</b><br>
     * Message is a video, information about the video
     */
    @Valid
    @JsonProperty("video")
    private final Video video;

    /**
     * <b>Optional.</b><br>
     * Message is a video note, information about the video message
     */
    @Valid
    @JsonProperty("video_note")
    private final VideoNote videoNote;

    /**
     * <b>Optional.</b><br>
     * Message is a voice message, information about the file
     */
    @Valid
    @JsonProperty("voice")
    private final Voice voice;

    /**
     * <b>Optional.</b><br>
     * Caption for the animation, audio, document, photo, video or voice
     */
    @JsonProperty("caption")
    private final String caption;

    /**
     * <b>Optional.</b><br>
     * For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in
     * the caption
     */
    @Valid
    @JsonProperty("caption_entities")
    private final List<MessageEntity> captionEntities;

    /**
     * <b>Optional.</b><br>
     * True, if the message media is covered by a spoiler animation
     */
    @JsonProperty("has_media_spoiler")
    private final Boolean hasMediaSpoiler;

    /**
     * <b>Optional.</b><br>
     * Message is a shared contact, information about the contact
     */
    @Valid
    @JsonProperty("contact")
    private final Contact contact;

    /**
     * <b>Optional.</b><br>
     * Message is a dice with random value
     */
    @Valid
    @JsonProperty("dice")
    private final Dice dice;

    /**
     * <b>Optional.</b><br>
     * Message is a game, information about the game.
     */
    @Valid
    @JsonProperty("game")
    private final Game game;

    /**
     * <b>Optional.</b><br>
     * Message is a native poll, information about the poll
     */
    @Valid
    @JsonProperty("poll")
    private final Poll poll;

    /**
     * <b>Optional.</b><br>
     * Message is a venue, information about the venue. For backward compatibility, when this field is set,
     * the location field will also be set
     */
    @Valid
    @JsonProperty("venue")
    private final Venue venue;

    /**
     * <b>Optional.</b><br>
     * Message is a shared location, information about the location
     */
    @Valid
    @JsonProperty("location")
    private final Location location;

    /**
     * <b>Optional.</b><br>
     * New members that were added to the group or supergroup and information about them (the bot itself may
     * be one of these members)
     */
    @Valid
    @JsonProperty("new_chat_members")
    private final List<User> newChatMembers;

    /**
     * <b>Optional.</b><br>
     * A member was removed from the group, information about them (this member may be the bot itself)
     */
    @Valid
    @JsonProperty("left_chat_member")
    private final User leftChatMember;

    /**
     * <b>Optional.</b><br>
     * A chat title was changed to this value
     */
    @JsonProperty("new_chat_title")
    private final String newChatTitle;

    /**
     * <b>Optional.</b><br>
     * A chat photo was change to this value
     */
    @Valid
    @JsonProperty("new_chat_photo")
    private final List<PhotoSize> newChatPhoto;

    /**
     * <b>Optional.</b><br>
     * Service message: the chat photo was deleted
     */
    @JsonProperty("delete_chat_photo")
    private final Boolean deleteChatPhoto;

    /**
     * <b>Optional.</b><br>
     * Service message: the group has been created
     */
    @JsonProperty("group_chat_created")
    private final Boolean groupChatCreated;

    /**
     * <b>Optional.</b><br>
     * Service message: the supergroup has been created. This field can't be received in a message coming
     * through updates, because bot can't be a member of a supergroup when it is created.
     * It can only be found in reply_to_message if someone replies to a very first message in a directly created
     * supergroup.
     */
    @JsonProperty("supergroup_chat_created")
    private final Boolean supergroupChatCreated;

    /**
     * <b>Optional.</b><br>
     * Service message: the channel has been created. This field can't be received in a message coming through
     * updates, because bot can't be a member of a channel when it is created.
     * It can only be found in reply_to_message if someone replies to a very first message in a channel.
     */
    @JsonProperty("channel_chat_created")
    private final Boolean channelChatCreated;

    /**
     * <b>Optional.</b><br>
     * Service message: auto-delete timer settings changed in the chat
     */
    @Valid
    @JsonProperty("message_auto_delete_timer_changed")
    private final MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged;

    /**
     * <b>Optional.</b><br>
     * The group has been migrated to a supergroup with the specified identifier.
     * This number may have more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or
     * double-precision float type are safe for storing this identifier.
     */
    @JsonProperty("migrate_to_chat_id")
    private final Long migrateToChatId;

    /**
     * <b>Optional.</b><br>
     * The supergroup has been migrated from a group with the specified identifier.
     * This number may have more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or
     * double-precision float type are safe for storing this identifier.
     */
    @JsonProperty("migrate_from_chat_id")
    private final Long migrateFromChatId;

    /**
     * <b>Optional.</b><br>
     * Specified message was pinned. Note that the Message object in this field will not contain further
     * reply_to_message fields even if it is itself a reply.
     */
    @Valid
    @JsonProperty("pinned_message")
    private final Message pinnedMessage;

    /**
     * <b>Optional.</b><br>
     * Message is an invoice for a payment, information about the invoice.
     */
    @Valid
    @JsonProperty("invoice")
    private final Invoice invoice;

    /**
     * <b>Optional.</b><br>
     * Message is a service message about a successful payment, information about the payment.
     */
    @Valid
    @JsonProperty("successful_payment")
    private final SuccessfulPayment successfulPayment;

    /**
     * <b>Optional.</b><br>
     * Service message: a user was shared with the bot
     */
    @Valid
    @JsonProperty("user_shared")
    private final UserShared userShared;

    /**
     * <b>Optional.</b><br>
     * Service message: a chat was shared with the bot
     */
    @Valid
    @JsonProperty("chat_shared")
    private final ChatShared chatShared;

    /**
     * <b>Optional.</b><br>
     * The domain name of the website on which the user has logged in.
     */
    @JsonProperty("connected_website")
    private final String connectedWebsite;

    /**
     * <b>Optional.</b><br>
     * Service message: the user allowed the bot added to the attachment menu to write messages
     */
    @Valid
    @JsonProperty("write_access_allowed")
    private final WriteAccessAllowed writeAccessAllowed;

    /**
     * <b>Optional.</b><br>
     * Telegram Passport data
     */
    @Valid
    @JsonProperty("passport_data")
    private final PassportData passportData;

    /**
     * <b>Optional.</b><br>
     * Service message.
     * A user in the chat triggered another user's proximity alert while sharing Live Location.
     */
    @Valid
    @JsonProperty("proximity_alert_triggered")
    private final ProximityAlertTriggered proximityAlertTriggered;

    /**
     * <b>Optional.</b><br>
     * Service message: forum topic created
     */
    @Valid
    @JsonProperty("forum_topic_created")
    private final ForumTopicCreated forumTopicCreated;

    /**
     * <b>Optional.</b><br>
     * Service message: forum topic edited
     */
    @Valid
    @JsonProperty("forum_topic_edited")
    private final ForumTopicEdited forumTopicEdited;

    /**
     * <b>Optional.</b><br>
     * Service message: forum topic closed
     */
    @Valid
    @JsonProperty("forum_topic_closed")
    private final ForumTopicClosed forumTopicClosed;

    /**
     * <b>Optional.</b><br>
     * Service message: forum topic reopened
     */
    @Valid
    @JsonProperty("forum_topic_reopened")
    private final ForumTopicReopened forumTopicReopened;

    /**
     * <b>Optional.</b><br>
     * Service message: the 'General' forum topic hidden
     */
    @Valid
    @JsonProperty("general_forum_topic_hidden")
    private final GeneralForumTopicHidden generalForumTopicHidden;

    /**
     * <b>Optional.</b><br>
     * Service message: the 'General' forum topic unhidden
     */
    @Valid
    @JsonProperty("general_forum_topic_unhidden")
    private final GeneralForumTopicUnhidden generalForumTopicUnhidden;

    /**
     * <b>Optional.</b><br>
     * Service message: video chat scheduled
     */
    @Valid
    @JsonProperty("video_chat_scheduled")
    private final VideoChatScheduled videoChatScheduled;

    /**
     * <b>Optional.</b><br>
     * Service message: video chat started
     */
    @Valid
    @JsonProperty("video_chat_started")
    private final VideoChatStarted videoChatStarted;

    /**
     * <b>Optional.</b><br>
     * Service message: video chat ended
     */
    @Valid
    @JsonProperty("video_chat_ended")
    private final VideoChatEnded videoChatEnded;

    /**
     * <b>Optional.</b><br>
     * Service message: new participants invited to a video chat
     */
    @Valid
    @JsonProperty("video_chat_participants_invited")
    private final VideoChatParticipantsInvited videoChatParticipantsInvited;

    /**
     * <b>Optional.</b><br>
     * Service message: data sent by a Web App
     */
    @Valid
    @JsonProperty("web_app_data")
    private final WebAppData webAppData;

    /**
     * <b>Optional.</b><br>
     * Inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

}
