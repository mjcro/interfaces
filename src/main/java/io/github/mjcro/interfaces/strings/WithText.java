package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a text body as a {@link String}.
 */
public interface WithText {
    /**
     * Returns the entity text.
     *
     * @return Entity text.
     */
    @NonNull String getText();

    /**
     * Checks whether the entity text equals the given text.
     *
     * @param given Text to compare to.
     * @return True if the texts are equal.
     */
    default boolean hasText(@NonNull String given) {
        return getText().equals(given);
    }
}
