package io.github.mjcro.interfaces.ints;

/**
 * Mixin interface for entities that carry an {@code int} gate identifier.
 */
public interface WithGateId {
    /**
     * Returns the gate identifier.
     *
     * @return Gate identifier.
     */
    int getGateId();

    /**
     * Checks whether the entity gate equals the given gate.
     *
     * @param given Gate to compare to.
     * @return True if the gates are equal.
     */
    default boolean hasGateId(int given) {
        return getGateId() == given;
    }
}
