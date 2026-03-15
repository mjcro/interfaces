package io.github.mjcro.interfaces.strings;

/**
 * Mixin interface for entities that carry a URL as a {@link String}.
 */
public interface WithUrl {
    /**
     * @return Entity URL.
     */
    String getURL();

    /**
     * Checks if entity URL equals to given one.
     *
     * @param given URL to compare to.
     * @return True if URL are equal.
     */
    default boolean hasURL(String given) {
        return getURL().equals(given);
    }
}
