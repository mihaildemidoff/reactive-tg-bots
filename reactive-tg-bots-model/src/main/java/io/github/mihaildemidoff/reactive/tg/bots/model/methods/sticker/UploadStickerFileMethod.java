package io.github.mihaildemidoff.reactive.tg.bots.model.methods.sticker;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.File;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.sticker.StickerFormat;
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
 * Use this method to upload a file with a sticker for later use in the createNewStickerSet and addStickerToSet methods
 * (the file can be used multiple times).
 * Returns the uploaded {@link File} on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#uploadstickerfile">uploadStickerFile</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadStickerFileMethod implements TypedBotMediaMethodDefinition<File> {

    /**
     * User identifier of sticker file owner
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format.
     * See https://core.telegram.org/stickers for technical requirements.
     */
    @Valid
    @NotNull
    @JsonProperty("sticker")
    private final InputFile sticker;

    /**
     * Format of the sticker, must be one of “static”, “animated”, “video”
     */
    @Valid
    @NotNull
    @JsonProperty("sticker_format")
    private final StickerFormat stickerFormat;

    @Override
    public TypeReference<GenericBotApiResponse<File>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.UPLOAD_STICKER_FILE;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Stream.ofNullable(sticker)
                .collect(Collectors.toList());
    }
}
