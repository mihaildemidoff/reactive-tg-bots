package io.github.mihaildemidoff.reactive.tg.bots.model.methods.file;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.File;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to get basic information about a file and prepare it for downloading. For the moment, bots can
 * download files of up to 20MB in size. On success, a
 * {@link File} object is returned. The file can then be
 * downloaded via the link https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;, where &lt;file_path&gt;
 * is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires,
 * a new one can be requested by calling getFile again.
 *
 * <b>Note:</b> This function may not preserve the original file name and MIME type. You should save the file's MIME
 * type and name (if available) when the File object is received.
 *
 * @see <a href="https://core.telegram.org/bots/api#getfile">getFile</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetFileMethod implements TypedBotMethodDefinition<File> {

    /**
     * File identifier to get information about
     */
    @NotNull
    @NotBlank
    @JsonProperty("file_id")
    private final String fileId;

    @Override
    public TypeReference<GenericBotApiResponse<File>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_FILE;
    }
}
