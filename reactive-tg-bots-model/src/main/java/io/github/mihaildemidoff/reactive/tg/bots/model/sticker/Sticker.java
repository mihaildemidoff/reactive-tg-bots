package io.github.mihaildemidoff.reactive.tg.bots.model.sticker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.File;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.PhotoSize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a sticker.
 *
 * @see <a href="https://core.telegram.org/bots/api#sticker">Sticker</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sticker implements BotApiResponse {

    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    @NotNull
    @JsonProperty("file_id")
    private final String fileId;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    @NotNull
    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    /**
     * Type of the sticker, currently one of “regular”, “mask”, “custom_emoji”. The type of the sticker is
     * independent from its format, which is determined by the fields is_animated and is_video.
     */
    @NotNull
    @JsonProperty("type")
    private final StickerType type;

    /**
     * Sticker width
     */
    @NotNull
    @JsonProperty("width")
    private final Long width;

    /**
     * Sticker height
     */
    @NotNull
    @JsonProperty("height")
    private final Long height;

    /**
     * True, if the sticker is animated
     */
    @NotNull
    @JsonProperty("is_animated")
    private final Boolean isAnimated;

    /**
     * True, if the sticker is a video sticker
     */
    @NotNull
    @JsonProperty("is_video")
    private final Boolean isVideo;

    /**
     * <b>Optional.</b><br>
     * Sticker thumbnail in the .WEBP or .JPG format
     */
    @Valid
    @JsonProperty("thumbnail")
    private final PhotoSize thumbnail;

    /**
     * <b>Optional.</b><br>
     * Emoji associated with the sticker
     */
    @JsonProperty("emoji")
    private final String emoji;

    /**
     * <b>Optional.</b><br>
     * Name of the sticker set to which the sticker belongs
     */
    @JsonProperty("set_name")
    private final String setName;

    /**
     * <b>Optional.</b><br>
     * For premium regular stickers, premium animation for the sticker
     */
    @Valid
    @JsonProperty("premium_animation")
    private final File premiumAnimation;

    /**
     * <b>Optional.</b><br>
     * For mask stickers, the position where the mask should be placed
     */
    @Valid
    @JsonProperty("mask_position")
    private final MaskPosition maskPosition;

    /**
     * <b>Optional.</b><br>
     * For custom emoji stickers, unique identifier of the custom emoji
     */
    @JsonProperty("custom_emoji_id")
    private final String customEmojiId;

    /**
     * <b>Optional.</b><br>
     * True, if the sticker must be repainted to a text color in messages, the color of the Telegram Premium
     * badge in emoji status, white color on chat photos, or another appropriate color in other places
     */
    @JsonProperty("needs_repainting")
    private final Boolean needsRepainting;

    /**
     * <b>Optional.</b><br>
     * File size in bytes
     */
    @JsonProperty("file_size")
    private final Long fileSize;

}
