package io.github.mihaildemidoff.reactive.tg.bots.model.methods;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the
 * user as a notification at the top of the chat screen or as an alert. On success, True is returned.
 * <p>
 * Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create
 * a game for your bot via @BotFather and accept the terms. Otherwise, you may use links like t.me/your_bot?start=XXXX
 * that open your bot with a parameter.
 *
 * @see <a href="https://core.telegram.org/bots/api#answercallbackquery">answerCallbackQuery</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerCallbackQueryMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the query to be answered
     */
    @NotNull
    @JsonProperty("callback_query_id")
    private final String callbackQueryId;

    /**
     * Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
     */
    @Size(max = 200)
    @JsonProperty("text")
    private final String text;

    /**
     * If True, an alert will be shown by the client instead of a notification at the top of the chat screen.
     * Defaults to false.
     */
    @JsonProperty("show_alert")
    private final Boolean showAlert;

    /**
     * URL that will be opened by the user's client. If you have created a Game and accepted the conditions
     * via @BotFather, specify the URL that opens your game - note that this will only work if the query comes from
     * a callback_game button.
     * <p>
     * Otherwise, you may use links like t.me/your_bot?start=XXXX that open your bot with a parameter.
     */
    @JsonProperty("url")
    private final String url;

    /**
     * The maximum amount of time in seconds that the result of the callback query may be cached client-side.
     * Telegram apps will support caching starting in version 3.14. Defaults to 0.
     */
    @JsonProperty("cache_time")
    // TODO: change to duration
    private final Long cacheTime;

    @Override
    public BotMethod getMethod() {
        return BotMethod.ANSWER_CALLBACK_QUERY;
    }
}
