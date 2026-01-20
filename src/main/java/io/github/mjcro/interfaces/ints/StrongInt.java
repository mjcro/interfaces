package io.github.mjcro.interfaces.ints;

/**
 * Interface defining custom strong integer types like:
 * 1. record ProductId(int value) implements StrongInt.
 * 2. record Limit(int value) implements StrongInt.
 * 3. record Page(int value) implements StrongInt.
 */
public interface StrongInt {
    /**
     * @return Value.
     */
    int value();

    /**
     * Checks if current wrapper contains same value as given one.
     *
     * @param candidate Value to compare to.
     * @return True if values are the same.
     */
    default boolean hasValue(int candidate) {
        return value() == candidate;
    }

    /**
     * Checks if current wrapper contains same value as given one.
     *
     * @param candidate Value to compare to.
     * @return True if values are not same.
     */
    default boolean notHasValue(int candidate) {
        return !hasValue(candidate);
    }
}
