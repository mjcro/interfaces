package io.github.mjcro.interfaces.strings;

/**
 * Mixin interface for entities that carry a URI as a {@link String}.
 */
public interface WithUri {
    /**
     * @return Entity URI.
     */
    String getURI();

    /**
     * Checks if entity URI equals to given one.
     *
     * @param given URI to compare to.
     * @return True if URI are equal.
     */
    default boolean hasURI(String given) {
        return getURI().equals(given);
    }
}
