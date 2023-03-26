package io.github.mjcro.interfaces.shorts;

public interface WithParentId {
    /**
     * @return Parent identifier.
     */
    short getParentId();

    /**
     * Checks if entity parent id equals to given one.
     *
     * @param given Given parent identifier.
     * @return True if parent identifiers are equal.
     */
    default boolean hasParentId(short given) {
        return getParentId() == given;
    }
}
