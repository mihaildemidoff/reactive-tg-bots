package io.github.mihaildemidoff.reactive.tg.bots.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a button to be shown above inline query results.
 * You must use exactly one of the optional fields.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultsbutton">InlineQueryResultsButton</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultsButton {

    /**
     * Label text on the button
     */
    @NotNull
    @JsonProperty("text")
    private final String text;

    /**
     * <b>Optional.</b><br>
     * Description of the Web App that will be launched when the user presses the button.
     * The Web App will be able to switch back to the inline mode using the method web_app_switch_inline_query inside
     * the Web App.
     */
    @Valid
    @JsonProperty("web_app")
    private final WebAppInfo webApp;

    /**
     * <b>Optional.</b><br>
     * Deep-linking parameter for the /start message sent to the bot when a user presses the button. 1-64 characters,
     * only A-Z, a-z, 0-9, _ and - are allowed.
     * <p>
     * Example: An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to
     * adapt search results accordingly. To do this, it displays a 'Connect your YouTube account' button above the
     * results, or even before showing any. The user presses the button, switches to a private chat with the bot and,
     * in doing so, passes a start parameter that instructs the bot to return an OAuth link. Once done, the bot can
     * offer a switch_inline button so that the user can easily return to the chat where they wanted to use the bot's
     * inline capabilities.
     */
    @Size(min = 1, max = 64)
    @JsonProperty("start_parameter")
    private final String startParameter;

}
