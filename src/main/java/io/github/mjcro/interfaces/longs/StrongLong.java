package io.github.mjcro.interfaces.longs;

/**
 * Interface defining custom strong long types like:
 * 1. record UserId(long value) implements StrongLong.
 * 2. record AmountCents(long value) implements StrongLong.
 */
public interface StrongLong {
    /**
     * @return Value.
     */
    long value();

    /**
     * Checks if current wrapper contains same value as given one.
     *
     * @param candidate Value to compare to.
     * @return True if values are the same.
     */
    default boolean hasValue(long candidate) {
        return value() == candidate;
    }

    /**
     * Checks if current wrapper contains same value as given one.
     *
     * @param candidate Value to compare to.
     * @return True if values are not same.
     */
    default boolean notHasValue(long candidate) {
        return !hasValue(candidate);
    }
}