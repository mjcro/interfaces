package io.github.mjcro.interfaces.longs;

/**
 * Mixin interface for entities that carry a {@code long} parent identifier.
 */
public interface WithParentId {
    /**
     * @return Parent identifier.
     */
    long getParentId();

    /**
     * Checks if entity parent id equals to given one.
     *
     * @param given Given parent identifier.
     * @return True if parent identifiers are equal.
     */
    default boolean hasParentId(long given) {
        return getParentId() == given;
    }
}
