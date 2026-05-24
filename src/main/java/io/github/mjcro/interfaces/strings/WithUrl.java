package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a URL as a {@link String}.
 */
public interface WithUrl {
    /**
     * Returns the entity URL.
     *
     * @return Entity URL.
     */
    @NonNull String getURL();

    /**
     * Checks whether the entity URL equals the given URL.
     *
     * @param given URL to compare to.
     * @return True if the URLs are equal.
     */
    default boolean hasURL(@NonNull String given) {
        return getURL().equals(given);
    }
}
