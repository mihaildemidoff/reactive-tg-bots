package io.github.mihaildemidoff.reactive.tg.bots.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.PhotoSize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * This object represent a user's profile pictures.
 *
 * @see <a href="https://core.telegram.org/bots/api#userprofilephotos">UserProfilePhotos</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfilesPhotos implements BotApiResponse {

    /**
     * Total number of profile pictures the target user has
     */
    @Valid
    @NotNull
    @JsonProperty("total_count")
    private final Long totalCount;

    /**
     * Requested profile pictures (in up to 4 sizes each)
     */
    @Valid
    @JsonProperty("photos")
    private final List<@Valid List<PhotoSize>> photos;

}
