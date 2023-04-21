package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommand;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommandScope;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommandScopeDefault;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.LanguageCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to change the list of the bot's commands.
 * See this <a href="https://core.telegram.org/bots/features#commands">manual</a> for more details about bot commands.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setmycommands">setMyCommands</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetMyCommandsMethod implements BooleanBotMethodDefinition {

    /**
     * A JSON-serialized list of bot commands to be set as the list of the bot's commands.
     * At most 100 commands can be specified.
     */
    @Valid
    @Size(max = 100)
    @NotNull
    @NotEmpty
    @JsonProperty("commands")
    private final List<BotCommand> commands;

    /**
     * A JSON-serialized object, describing scope of users for which the commands are relevant.
     * Defaults to {@link BotCommandScopeDefault}.
     */
    @Valid
    @JsonProperty("scope")
    private final BotCommandScope scope;

    /**
     * A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope,
     * for whose language there are no dedicated commands
     */
    @JsonProperty("language_code")
    private final LanguageCode languageCode;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_MY_COMMANDS;
    }
}
