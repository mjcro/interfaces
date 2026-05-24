package io.github.mjcro.interfaces.shorts;

/**
 * Mixin interface for entities that carry a {@code short} gate identifier.
 */
public interface WithGateId {
    /**
     * Returns the gate identifier.
     *
     * @return Gate identifier.
     */
    short getGateId();

    /**
     * Checks whether the entity gate equals the given gate.
     *
     * @param given Gate to compare to.
     * @return True if the gates are equal.
     */
    default boolean hasGateId(short given) {
        return getGateId() == given;
    }
}
