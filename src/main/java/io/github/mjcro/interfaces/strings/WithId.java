package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a {@link String} identifier.
 */
public interface WithId {
    /**
     * Returns the entity identifier.
     *
     * @return Entity identifier.
     */
    @NonNull String getId();

    /**
     * Checks whether the entity identifier equals the given identifier.
     *
     * @param given Identifier to compare to.
     * @return True if the identifiers are equal.
     */
    default boolean hasId(@NonNull String given) {
        return getId().equals(given);
    }
}
