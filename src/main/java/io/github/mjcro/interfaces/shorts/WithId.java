package io.github.mjcro.interfaces.shorts;

public interface WithId {
    /**
     * @return Identifier of entity
     */
    short getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(short given) {
        return getId() == given;
    }
}
