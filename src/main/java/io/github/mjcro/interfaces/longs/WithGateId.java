package io.github.mjcro.interfaces.longs;

/**
 * Mixin interface for entities that carry a {@code long} gate identifier.
 */
public interface WithGateId {
    /**
     * Returns the gate identifier.
     *
     * @return Gate identifier.
     */
    long getGateId();

    /**
     * Checks whether the entity gate equals the given gate.
     *
     * @param given Gate to compare to.
     * @return True if the gates are equal.
     */
    default boolean hasGateId(long given) {
        return getGateId() == given;
    }
}
