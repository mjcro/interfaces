package io.github.mjcro.interfaces.longs;

/**
 * Mixin interface for entities that carry a {@code long} gate identifier.
 */
public interface WithGateId {
    /**
     * @return Gate identifier.
     */
    long getGateId();

    /**
     * Checks if entity gate equals to given one.
     *
     * @param given Gate to compare to.
     * @return True if gates are equal.
     */
    default boolean hasGateId(long given) {
        return getGateId() == given;
    }
}
