package io.github.mihaildemidoff.reactive.tg.bots.model.videochat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * This object represents a service message about new members invited to a video chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#videochatparticipantsinvited">VideoChatParticipantsInvited</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoChatParticipantsInvited {

    /**
     * New members that were invited to the video chat
     */
    @Valid
    @NotNull
    @JsonProperty("users")
    private final List<User> users;

}
