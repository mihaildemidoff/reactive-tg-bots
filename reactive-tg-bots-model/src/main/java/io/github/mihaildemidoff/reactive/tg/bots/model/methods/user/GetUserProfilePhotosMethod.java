package io.github.mihaildemidoff.reactive.tg.bots.model.methods.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.UserProfilesPhotos;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to get a list of profile pictures for a user.
 * Returns a {@link UserProfilesPhotos} object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getuserprofilephotos">getUserProfilePhotos</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserProfilePhotosMethod implements TypedBotMethodDefinition<UserProfilesPhotos> {

    /**
     * Unique identifier of the target user
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * Sequential number of the first photo to be returned. By default, all photos are returned.
     */
    @JsonProperty("offset")
    private final Long offset;

    /**
     * Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     */
    @JsonProperty("limit")
    private final Long limit;

    @Override
    public TypeReference<GenericBotApiResponse<UserProfilesPhotos>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_USER_PROFILE_PHOTOS;
    }
}
