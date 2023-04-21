package io.github.mihaildemidoff.reactive.tg.bots.model.videochat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a service message about a video chat started in the chat. Currently holds no information.
 *
 * @see <a href="https://core.telegram.org/bots/api#videochatstarted">VideoChatStarted</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoChatStarted {

}
