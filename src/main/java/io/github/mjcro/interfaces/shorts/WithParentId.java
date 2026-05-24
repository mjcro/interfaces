package io.github.mjcro.interfaces.shorts;

/**
 * Mixin interface for entities that carry a {@code short} parent identifier.
 */
public interface WithParentId {
    /**
     * Returns the parent entity identifier.
     *
     * @return Parent identifier.
     */
    short getParentId();

    /**
     * Checks whether the entity parent identifier equals the given identifier.
     *
     * @param given Given parent identifier.
     * @return True if the parent identifiers are equal.
     */
    default boolean hasParentId(short given) {
        return getParentId() == given;
    }
}
