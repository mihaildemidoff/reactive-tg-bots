package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.media;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to edit animation, audio, document, photo, or video messages. If a message is part of a message
 * album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a
 * photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously
 * uploaded file via its file_id or specify a URL. On success True is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagemedia">editMessageMedia</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditInlineMessageMediaMethod
        extends AbstractEditMessageMediaMethod<Boolean> implements BooleanBotMethodDefinition {

    /**
     * Identifier of the inline message
     */
    @NotNull
    @JsonProperty("inline_message_id")
    private final String inlineMessageId;


}
