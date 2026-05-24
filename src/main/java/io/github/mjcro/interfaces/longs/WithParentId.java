package io.github.mjcro.interfaces.longs;

/**
 * Mixin interface for entities that carry a {@code long} parent identifier.
 */
public interface WithParentId {
    /**
     * Returns the parent entity identifier.
     *
     * @return Parent identifier.
     */
    long getParentId();

    /**
     * Checks whether the entity parent identifier equals the given identifier.
     *
     * @param given Given parent identifier.
     * @return True if the parent identifiers are equal.
     */
    default boolean hasParentId(long given) {
        return getParentId() == given;
    }
}
