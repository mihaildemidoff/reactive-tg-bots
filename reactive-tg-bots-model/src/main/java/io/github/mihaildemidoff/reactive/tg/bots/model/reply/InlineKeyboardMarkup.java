package io.github.mihaildemidoff.reactive.tg.bots.model.reply;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.InlineKeyboardButton;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">InlineKeyboardMarkup</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineKeyboardMarkup implements ReplyMarkup {

    /**
     * Array of button rows, each represented by an Array of InlineKeyboardButton objects
     */
    @Valid
    @NotNull
    @JsonProperty("inline_keyboard")
    private final List<@Valid List<InlineKeyboardButton>> inlineKeyboard;

}
