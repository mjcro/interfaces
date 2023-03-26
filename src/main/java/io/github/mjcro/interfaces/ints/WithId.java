package io.github.mjcro.interfaces.ints;

public interface WithId {
    /**
     * @return Identifier of entity
     */
    int getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(int given) {
        return getId() == given;
    }
}
