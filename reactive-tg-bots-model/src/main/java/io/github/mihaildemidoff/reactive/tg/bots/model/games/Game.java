package io.github.mihaildemidoff.reactive.tg.bots.model.games;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.Animation;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.PhotoSize;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * This object represents a game.
 * Use BotFather to create and edit games, their short names will act as unique identifiers.
 *
 * @see <a href="https://core.telegram.org/bots/api#game">Game</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    /**
     * Title of the game
     */
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * Description of the game
     */
    @NotNull
    @JsonProperty("description")
    private final String description;

    /**
     * Photo that will be displayed in the game message in chats.
     */
    @Valid
    @NotNull
    @JsonProperty("photo")
    private final List<PhotoSize> photo;

    /**
     * <b>Optional.</b><br>
     * Brief description of the game or high scores included in the game message.
     * Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or
     * manually edited using editMessageText. 0-4096 characters.
     */
    @Size(max = 4096)
    @JsonProperty("text")
    private final String text;

    /**
     * <b>Optional.</b><br>
     * Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    @Valid
    @JsonProperty("text_entities")
    private final List<MessageEntity> textEntities;

    /**
     * <b>Optional.</b><br>
     * Animation that will be displayed in the game message in chats. Upload via BotFather
     */
    @Valid
    @JsonProperty("animation")
    private final Animation animation;

}
