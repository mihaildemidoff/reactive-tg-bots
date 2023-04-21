package io.github.mihaildemidoff.reactive.tg.bots.model.sticker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object describes the position on faces where a mask should be placed by default.
 *
 * @see <a href="https://core.telegram.org/bots/api#maskposition">MaskPosition</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskPosition {

    /**
     * The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
     */
    @NotNull
    @JsonProperty("point")
    private final MaskPositionPoint point;

    /**
     * Shift by X-axis measured in widths of the mask scaled to the face size, from left to right.
     * For example, choosing -1.0 will place mask just to the left of the default mask position.
     */
    @NotNull
    @JsonProperty("x_shift")
    private final Double xShift;

    /**
     * Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom.
     * For example, 1.0 will place the mask just below the default mask position.
     */
    @NotNull
    @JsonProperty("y_shift")
    private final Double yShift;

    /**
     * Mask scaling coefficient. For example, 2.0 means double size.
     */
    @NotNull
    @JsonProperty("scale")
    private final Double scale;
}
