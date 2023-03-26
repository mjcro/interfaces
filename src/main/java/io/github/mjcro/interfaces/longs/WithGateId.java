package io.github.mjcro.interfaces.longs;

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
