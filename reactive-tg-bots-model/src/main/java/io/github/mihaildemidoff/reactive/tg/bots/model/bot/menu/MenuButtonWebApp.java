package io.github.mihaildemidoff.reactive.tg.bots.model.bot.menu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.WebAppInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a menu button, which launches a Web App.
 *
 * @see <a href="https://core.telegram.org/bots/api#menubuttonwebapp">MenuButtonWebApp</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuButtonWebApp implements MenuButton {

    /**
     * Type of the button, must be web_app
     */
    @NotNull
    @JsonProperty("type")
    private final MenuButtonType type = MenuButtonType.WEB_APP;

    /**
     * Text on the button
     */
    @NotNull
    @JsonProperty("text")
    private final String text;

    /**
     * Description of the Web App that will be launched when the user presses the button. The Web App will be able to
     * send an arbitrary message on behalf of the user using the method answerWebAppQuery.
     */
    @Valid
    @NotNull
    @JsonProperty("web_app")
    private final WebAppInfo webApp;
}
