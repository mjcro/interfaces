package io.github.mjcro.interfaces.ints;

/**
 * Mixin interface for entities that carry an {@code int} parent identifier.
 */
public interface WithParentId {
    /**
     * Returns the parent entity identifier.
     *
     * @return Parent identifier.
     */
    int getParentId();

    /**
     * Checks whether the entity parent identifier equals the given identifier.
     *
     * @param given Given parent identifier.
     * @return True if the parent identifiers are equal.
     */
    default boolean hasParentId(int given) {
        return getParentId() == given;
    }
}
