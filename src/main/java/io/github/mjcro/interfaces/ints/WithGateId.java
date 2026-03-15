package io.github.mjcro.interfaces.ints;

/**
 * Mixin interface for entities that carry an {@code int} gate identifier.
 */
public interface WithGateId {
    /**
     * @return Gate identifier.
     */
    int getGateId();

    /**
     * Checks if entity gate equals to given one.
     *
     * @param given Gate to compare to.
     * @return True if gates are equal.
     */
    default boolean hasGateId(int given) {
        return getGateId() == given;
    }
}
