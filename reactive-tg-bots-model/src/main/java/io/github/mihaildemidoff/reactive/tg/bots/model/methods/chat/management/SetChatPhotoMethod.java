package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.management;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.StreamedInputFile;
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
 * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats.
 * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatphoto">setChatPhoto</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetChatPhotoMethod implements BooleanBotMediaMethodDefinition {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * New chat photo, uploaded using multipart/form-data
     */
    @Valid
    @NotNull
    @JsonProperty("photo")
    private final StreamedInputFile photo;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_CHAT_PHOTO;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Stream.ofNullable(photo)
                .collect(Collectors.toList());
    }
}
