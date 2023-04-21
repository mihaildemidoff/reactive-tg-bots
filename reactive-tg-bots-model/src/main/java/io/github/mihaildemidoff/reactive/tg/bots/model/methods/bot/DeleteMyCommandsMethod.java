package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommandScope;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommandScopeDefault;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.LanguageCode;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to delete the list of the bot's commands for the given scope and user language.
 * After deletion, higher level commands will be shown to affected users. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletemycommands">deleteMyCommands</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteMyCommandsMethod implements BooleanBotMethodDefinition {

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
        return BotMethod.DELETE_MY_COMMANDS;
    }
}
