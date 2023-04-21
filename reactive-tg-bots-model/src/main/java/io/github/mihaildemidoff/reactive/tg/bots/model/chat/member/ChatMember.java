package io.github.mihaildemidoff.reactive.tg.bots.model.chat.member;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Base interface for chat member.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmember">ChatMember</a>
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "status")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChatMemberAdministrator.class, name = "administrator"),
        @JsonSubTypes.Type(value = ChatMemberBanned.class, name = "kicked"),
        @JsonSubTypes.Type(value = ChatMemberLeft.class, name = "left"),
        @JsonSubTypes.Type(value = ChatMemberMember.class, name = "member"),
        @JsonSubTypes.Type(value = ChatMemberOwner.class, name = "creator"),
        @JsonSubTypes.Type(value = ChatMemberRestricted.class, name = "restricted")
})
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ChatMember implements BotApiResponse {

    /**
     * Information about the user
     */
    @NotNull
    @JsonProperty("user")
    private final User user;

    /**
     * Chat member status
     *
     * @return status
     */
    abstract ChatMemberStatus getStatus();

}
