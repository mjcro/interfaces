package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a URL as a {@link String}.
 */
public interface WithUrl {
    /**
     * @return Entity URL.
     */
    @NonNull String getURL();

    /**
     * Checks if entity URL equals to given one.
     *
     * @param given URL to compare to.
     * @return True if URL are equal.
     */
    default boolean hasURL(@NonNull String given) {
        return getURL().equals(given);
    }
}
