package io.github.mjcro.interfaces.shorts;

/**
 * Mixin interface for entities that carry a {@code short} gate identifier.
 */
public interface WithGateId {
    /**
     * @return Gate identifier.
     */
    short getGateId();

    /**
     * Checks if entity gate equals to given one.
     *
     * @param given Gate to compare to.
     * @return True if gates are equal.
     */
    default boolean hasGateId(short given) {
        return getGateId() == given;
    }
}
