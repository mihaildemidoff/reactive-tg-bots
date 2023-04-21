package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendDocumentMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendMessageMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendPhotoMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendVideoMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendVideoNoteMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendVoiceMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker.SendStickerMethod;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Type of action to broadcast.
 */
@RequiredArgsConstructor
public enum ChatAction {

    /**
     * typing. for {@link SendMessageMethod}
     */
    TYPING("typing"),

    /**
     * upload_photo. for {@link SendPhotoMethod}
     */
    UPLOAD_PHOTO("upload_photo"),

    /**
     * record_video. for {@link SendVideoMethod}
     */
    RECORD_VIDEO("record_video"),

    /**
     * upload_video. for {@link SendVideoMethod}
     */
    UPLOAD_VIDEO("upload_video"),

    /**
     * record_voice. for {@link SendVoiceMethod}
     */
    RECORD_VOICE("record_voice"),

    /**
     * upload_voice. for {@link SendVoiceMethod}
     */
    UPLOAD_VOICE("upload_voice"),

    /**
     * upload_document. for {@link SendDocumentMethod}
     */
    UPLOAD_DOCUMENT("upload_document"),

    /**
     * choose_sticker. for {@link SendStickerMethod}
     */
    CHOOSE_STICKER("choose_sticker"),

    /**
     * find_location. for {@link SendMethod}
     */
    FIND_LOCATION("find_location"),

    /**
     * record_video_note.
     * for {@link SendVideoNoteMethod}
     */
    RECORD_VIDEO_NOTE("record_video_note"),

    /**
     * upload_video_note.
     * for {@link SendVideoNoteMethod}
     */
    UPLOAD_VIDEO_NOTE("upload_video_note");

    /**
     * String value of enum
     */
    private final String value;

    /**
     * Returns string representation of enum.
     *
     * @return string value of enum
     */
    @JsonValue
    public String toValue() {
        return value;
    }

    /**
     * Finds enum value for provided string.
     *
     * @param source string representation of enum
     * @return found enum or null if enum not found
     */
    @JsonCreator
    public static ChatAction fromValue(final String source) {
        return Stream.of(ChatAction.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
