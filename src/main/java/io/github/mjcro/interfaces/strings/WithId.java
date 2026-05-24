package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that carry a {@link String} identifier.
 */
public interface WithId {
    /**
     * @return Identifier of entity.
     */
    @NonNull String getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(@NonNull String given) {
        return getId().equals(given);
    }
}
