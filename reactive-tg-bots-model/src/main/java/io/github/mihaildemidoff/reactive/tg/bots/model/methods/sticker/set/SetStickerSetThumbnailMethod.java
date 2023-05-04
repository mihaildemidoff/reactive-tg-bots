package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker.set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Use this method to set the thumbnail of a regular or mask sticker set.
 * The format of the thumbnail file must match the format of the stickers in the set. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">setStickerSetThumbnail</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetStickerSetThumbnailMethod implements BooleanBotMediaMethodDefinition {

    /**
     * Sticker set name
     */
    @NotNull
    @JsonProperty("name")
    private final String name;

    /**
     * User identifier of sticker set owner
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * A .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size and have a width and height of
     * exactly 100px, or a .TGS animation with a thumbnail up to 32 kilobytes in size
     * (see https://core.telegram.org/stickers#animated-sticker-requirements for animated sticker technical
     * requirements), or a WEBM video with the thumbnail up to 32 kilobytes in size;
     * see https://core.telegram.org/stickers#video-sticker-requirements for video sticker technical requirements.
     * Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a
     * String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data.
     * Animated and video sticker set thumbnails can't be uploaded via HTTP URL.
     * If omitted, then the thumbnail is dropped and the first sticker is used as the thumbnail.
     */
    @Valid
    @JsonProperty("sticker")
    private final InputFile thumbnail;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_STICKER_SET_THUMBNAIL;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Stream.ofNullable(thumbnail)
                .collect(Collectors.toList());
    }
}
