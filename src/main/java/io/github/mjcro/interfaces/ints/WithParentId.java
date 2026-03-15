package io.github.mjcro.interfaces.ints;

/**
 * Mixin interface for entities that carry an {@code int} parent identifier.
 */
public interface WithParentId {
    /**
     * @return Parent identifier.
     */
    int getParentId();

    /**
     * Checks if entity parent id equals to given one.
     *
     * @param given Given parent identifier.
     * @return True if parent identifiers are equal.
     */
    default boolean hasParentId(int given) {
        return getParentId() == given;
    }
}
