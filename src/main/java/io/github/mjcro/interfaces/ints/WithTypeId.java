package io.github.mjcro.interfaces.ints;

public interface WithTypeId {
    /**
     * @return Type identifier.
     */
    int getTypeId();

    /**
     * Checks if entity type identifier equals to given one.
     *
     * @param given Type to compare to.
     * @return True if types are equal.
     */
    default boolean hasTypeId(int given) {
        return getTypeId() == given;
    }
}
