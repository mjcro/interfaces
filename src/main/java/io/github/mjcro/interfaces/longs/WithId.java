package io.github.mjcro.interfaces.longs;

/**
 * Mixin interface for entities that carry a {@code long} identifier.
 */
public interface WithId {
    /**
     * Returns the entity identifier.
     *
     * @return Entity identifier.
     */
    long getId();

    /**
     * Checks whether the entity identifier equals the given identifier.
     *
     * @param given Identifier to compare to.
     * @return True if the identifiers are equal.
     */
    default boolean hasId(long given) {
        return getId() == given;
    }
}
