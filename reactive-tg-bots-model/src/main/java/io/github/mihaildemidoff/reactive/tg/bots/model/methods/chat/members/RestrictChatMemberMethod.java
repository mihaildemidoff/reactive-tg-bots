package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.members;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.ChatPermissions;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

/**
 * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to
 * work and must have the appropriate administrator rights. Pass True for all permissions to lift restrictions from a
 * user. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#restrictchatmember">restrictChatMember</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestrictChatMemberMethod implements BooleanBotMethodDefinition {

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
     * A JSON-serialized object for new user permissions
     */
    @Valid
    @NotNull
    @JsonProperty("permissions")
    private final ChatPermissions permissions;

    /**
     * Pass True if chat permissions are set independently. Otherwise, the can_send_other_messages and
     * can_add_web_page_previews permissions will imply the can_send_messages, can_send_audios, can_send_documents,
     * can_send_photos, can_send_videos, can_send_video_notes, and can_send_voice_notes permissions;
     * the can_send_polls permission will imply the can_send_messages permission.
     */
    @JsonProperty("use_independent_chat_permissions")
    private final Boolean useIndependentChatPermissions;

    /**
     * Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or
     * less than 30 seconds from the current time, they are considered to be restricted forever
     */
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("until_date")
    private final Instant untilDate;


    @Override
    public BotMethod getMethod() {
        return BotMethod.RESTRICT_CHAT_MEMBER;
    }
}
