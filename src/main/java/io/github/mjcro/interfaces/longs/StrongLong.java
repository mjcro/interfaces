package io.github.mjcro.interfaces.longs;

/**
 * Interface defining custom strong long types like:
 * 1. record UserId(long value) implements StrongLong.
 * 2. record AmountCents(long value) implements StrongLong.
 */
public interface StrongLong {
    /**
     * Returns the wrapped long value.
     *
     * @return Wrapped value.
     */
    long value();

    /**
     * Checks whether this wrapper contains the given value.
     *
     * @param candidate Value to compare to.
     * @return True if the values are the same.
     */
    default boolean hasValue(long candidate) {
        return value() == candidate;
    }

    /**
     * Checks whether this wrapper contains the given value.
     *
     * @param candidate Value to compare to.
     * @return True if the values are different.
     */
    default boolean notHasValue(long candidate) {
        return !hasValue(candidate);
    }
}