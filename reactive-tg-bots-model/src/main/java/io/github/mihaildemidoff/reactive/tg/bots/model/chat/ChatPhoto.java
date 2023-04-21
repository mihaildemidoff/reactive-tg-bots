package io.github.mihaildemidoff.reactive.tg.bots.model.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a chat photo.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatphoto">ChatPhoto</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatPhoto {

    /**
     * File identifier of small (160x160) chat photo.
     * This file_id can be used only for photo download and only for as long as the photo is not changed.
     */
    @NotNull
    @JsonProperty("small_file_id")
    private final String smallFileId;

    /**
     * Unique file identifier of small (160x160) chat photo, which is supposed to be the same over time and for
     * different bots. Can't be used to download or reuse the file.
     */
    @NotNull
    @JsonProperty("small_file_unique_id")
    private final String smallFileUniqueId;

    /**
     * File identifier of big (640x640) chat photo. This file_id can be used only for photo download and only for as
     * long as the photo is not changed.
     */
    @NotNull
    @JsonProperty("big_file_id")
    private final String bigFileId;

    /**
     * Unique file identifier of big (640x640) chat photo, which is supposed to be the same over time and for different
     * bots. Can't be used to download or reuse the file.
     */
    @NotNull
    @JsonProperty("big_file_unique_id")
    private final String bigFileUniqueId;
}
