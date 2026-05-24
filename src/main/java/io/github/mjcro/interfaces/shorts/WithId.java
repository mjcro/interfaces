package io.github.mjcro.interfaces.shorts;

/**
 * Mixin interface for entities that carry a {@code short} identifier.
 */
public interface WithId {
    /**
     * Returns the entity identifier.
     *
     * @return Entity identifier.
     */
    short getId();

    /**
     * Checks whether the entity identifier equals the given identifier.
     *
     * @param given Identifier to compare to.
     * @return True if the identifiers are equal.
     */
    default boolean hasId(short given) {
        return getId() == given;
    }
}
