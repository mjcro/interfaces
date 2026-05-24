package io.github.mjcro.interfaces.ints;

/**
 * Mixin interface for entities that carry an {@code int} identifier.
 */
public interface WithId {
    /**
     * Returns the entity identifier.
     *
     * @return Entity identifier.
     */
    int getId();

    /**
     * Checks whether the entity identifier equals the given identifier.
     *
     * @param given Identifier to compare to.
     * @return True if the identifiers are equal.
     */
    default boolean hasId(int given) {
        return getId() == given;
    }
}
