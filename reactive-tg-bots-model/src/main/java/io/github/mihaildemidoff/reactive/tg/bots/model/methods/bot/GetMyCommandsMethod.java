package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommand;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommandScope;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommandScopeDefault;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.ListBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.LanguageCode;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to get the current list of the bot's commands for the given scope and user language.
 * Returns an Array of {@link BotCommand} objects.
 * If commands aren't set, an empty list is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#getmycommands">getMyCommands</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMyCommandsMethod implements ListBotMethodDefinition<BotCommand> {

    /**
     * A JSON-serialized object, describing scope of users.
     * Defaults to {@link BotCommandScopeDefault}.
     */
    @Valid
    @JsonProperty("scope")
    private final BotCommandScope scope;

    /**
     * A two-letter ISO 639-1 language code or an empty string
     */
    @JsonProperty("language_code")
    private final LanguageCode languageCode;

    @Override
    public TypeReference<GenericBotApiResponse<List<BotCommand>>> getResponseClass() {
        return new TypeReference<GenericBotApiResponse<List<BotCommand>>>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_MY_COMMANDS;
    }
}
