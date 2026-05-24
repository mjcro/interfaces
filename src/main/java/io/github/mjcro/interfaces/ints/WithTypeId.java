package io.github.mjcro.interfaces.ints;

/**
 * Mixin interface for entities that carry an {@code int} type identifier.
 */
public interface WithTypeId {
    /**
     * Returns the type identifier.
     *
     * @return Type identifier.
     */
    int getTypeId();

    /**
     * Checks whether the entity type identifier equals the given identifier.
     *
     * @param given Type to compare to.
     * @return True if the types are equal.
     */
    default boolean hasTypeId(int given) {
        return getTypeId() == given;
    }
}
