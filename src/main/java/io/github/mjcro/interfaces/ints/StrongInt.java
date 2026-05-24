package io.github.mjcro.interfaces.ints;

/**
 * Interface defining custom strong integer types like:
 * 1. record ProductId(int value) implements StrongInt.
 * 2. record Limit(int value) implements StrongInt.
 * 3. record Page(int value) implements StrongInt.
 */
public interface StrongInt {
    /**
     * Returns the wrapped int value.
     *
     * @return Wrapped value.
     */
    int value();

    /**
     * Checks whether this wrapper contains the given value.
     *
     * @param candidate Value to compare to.
     * @return True if the values are the same.
     */
    default boolean hasValue(int candidate) {
        return value() == candidate;
    }

    /**
     * Checks whether this wrapper contains the given value.
     *
     * @param candidate Value to compare to.
     * @return True if the values are different.
     */
    default boolean notHasValue(int candidate) {
        return !hasValue(candidate);
    }
}
