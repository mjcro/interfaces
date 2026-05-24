package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a URI as a {@link String}.
 */
public interface WithUri {
    /**
     * Returns the entity URI.
     *
     * @return Entity URI.
     */
    @NonNull String getURI();

    /**
     * Checks whether the entity URI equals the given URI.
     *
     * @param given URI to compare to.
     * @return True if the URIs are equal.
     */
    default boolean hasURI(@NonNull String given) {
        return getURI().equals(given);
    }
}
