package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a text body as a {@link String}.
 */
public interface WithText {
    /**
     * @return Entity text.
     */
    @NonNull String getText();

    /**
     * Checks if entity text equals to given one.
     *
     * @param given Text to compare to.
     * @return True if texts are equal.
     */
    default boolean hasText(@NonNull String given) {
        return getText().equals(given);
    }
}
