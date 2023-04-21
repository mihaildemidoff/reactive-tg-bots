package io.github.mihaildemidoff.reactive.tg.bots.model.sticker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * This object describes a sticker to be added to a sticker set.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputsticker">InputSticker</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputSticker {

    /**
     * The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass
     * an HTTP URL as a String for Telegram to get a file from the Internet, upload a new one using multipart/form-data,
     * or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under
     * &lt;file_attach_name&gt; name. Animated and video stickers can't be uploaded via HTTP URL.
     */
    @Valid
    @NotNull
    @JsonProperty("sticker")
    private final InputFile sticker;

    /**
     * List of 1-20 emoji associated with the sticker
     */
    @Size(min = 1, max = 20)
    @NotNull
    @JsonProperty("emoji_list")
    // TODO: add emoji validation
    private final List<String> emojiList;

    /**
     * <b>Optional.</b><br>
     * Position where the mask should be placed on faces. For “mask” stickers only.
     */
    @Valid
    @JsonProperty("mask_position")
    private final MaskPosition maskPosition;

    /**
     * <b>Optional.</b><br>
     * List of 0-20 search keywords for the sticker with total length of up to 64 characters.
     * For “regular” and “custom_emoji” stickers only.
     */
    @Size(max = 20)
    @JsonProperty("keywords")
    private final List<@Size(max = 64) String> keywords;

}
