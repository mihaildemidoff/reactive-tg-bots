package io.github.mihaildemidoff.reactive.tg.bots.model.chat.member;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

/**
 * Represents a chat member that was banned in the chat and can't return to the chat or view chat messages.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberbanned">ChatMemberBanned</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMemberBanned extends ChatMember {

    /**
     * The member's status in the chat, always “kicked”
     */
    @NotNull
    @JsonProperty("status")
    private final ChatMemberStatus status = ChatMemberStatus.KICKED;

    /**
     * Date when restrictions will be lifted for this user; unix time.
     * If 0, then the user is banned forever. Check seconds of instant
     */
    @NotNull
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("until_date")
    private final Instant untilDate;


}
