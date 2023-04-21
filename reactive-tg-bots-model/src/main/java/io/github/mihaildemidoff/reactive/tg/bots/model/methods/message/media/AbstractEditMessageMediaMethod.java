package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.media;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.media.InputMedia;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Optional;

/**
 * Use this method to edit animation, audio, document, photo, or video messages. If a message is part of a message
 * album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a
 * photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously
 * uploaded file via its file_id or specify a URL.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagemedia">editMessageMedia</a>
 * @see EditInlineMessageMediaMethod
 * @see EditMessageMediaMethod
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEditMessageMediaMethod<RESPONSE> implements BaseBotMediaMethodDefinition<RESPONSE> {

    /**
     * A JSON-serialized object for a new media content of the message
     */
    @Valid
    @NotNull
    @JsonProperty("media")
    private final InputMedia media;

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    @Override
    public BotMethod getMethod() {
        return BotMethod.EDIT_MESSAGE_MEDIA;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Optional.ofNullable(media)
                .map(InputMedia::getInputFiles)
                .orElse(List.of());
    }
}
