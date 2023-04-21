package io.github.mihaildemidoff.reactive.tg.bots.model.sticker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.PhotoSize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * This object represents a sticker set.
 *
 * @see <a href="https://core.telegram.org/bots/api#stickerset">StickerSet</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class StickerSet implements BotApiResponse {

    /**
     * Sticker set name
     */
    @NotNull
    @JsonProperty("name")
    private final String name;

    /**
     * Sticker set title
     */
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * Type of stickers in the set, currently one of “regular”, “mask”, “custom_emoji”
     */
    @NotNull
    @JsonProperty("sticker_type")
    private final StickerType stickerType;

    /**
     * True, if the sticker set contains animated stickers
     */
    @NotNull
    @JsonProperty("is_animated")
    private final Boolean isAnimated;

    /**
     * rue, if the sticker set contains video stickers
     */
    @NotNull
    @JsonProperty("is_video")
    private final Boolean isVideo;

    /**
     * List of all set stickers
     */
    @Valid
    @NotNull
    @JsonProperty("stickers")
    private final List<Sticker> stickers;

    /**
     * <b>Optional.</b><br>
     * Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
     */
    @Valid
    @JsonProperty("thumbnail")
    private final PhotoSize thumbnail;

}
