package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.management;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.chat.ChatPermissions;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a
 * supergroup for this to work and must have the can_restrict_members administrator rights.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatpermissions">setChatPermissions</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetChatPermissionsMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * A JSON-serialized object for new default chat permissions
     */
    @Valid
    @NotNull
    @JsonProperty("permissions")
    private final ChatPermissions permissions;

    /**
     * Pass True if chat permissions are set independently. Otherwise, the can_send_other_messages and
     * can_add_web_page_previews permissions will imply the can_send_messages, can_send_audios, can_send_documents,
     * can_send_photos, can_send_videos, can_send_video_notes, and can_send_voice_notes permissions; the can_send_polls
     * permission will imply the can_send_messages permission.
     */
    @JsonProperty("use_independent_chat_permissions")
    private final Boolean useIndependentChatPermissions;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_CHAT_PERMISSIONS;
    }
}
