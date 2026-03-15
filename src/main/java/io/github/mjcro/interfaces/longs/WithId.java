package io.github.mjcro.interfaces.longs;

/**
 * Mixin interface for entities that carry a {@code long} identifier.
 */
public interface WithId {
    /**
     * @return Identifier of entity
     */
    long getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(long given) {
        return getId() == given;
    }
}
