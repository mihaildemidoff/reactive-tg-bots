package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.livelocation.edit;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to edit live location messages. A location can be edited until its live_period expires or editing is
 * explicitly disabled by a call to stopMessageLiveLocation.
 * On success True is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagelivelocation">editMessageLiveLocation</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditInlineMessageLiveLocationMethod
        extends AbstractEditMessageLiveLocationMethod<Boolean> implements BooleanBotMethodDefinition {

    /**
     * Identifier of the inline message
     */
    @NotNull
    @JsonProperty("inline_message_id")
    private final String inlineMessageId;

}
