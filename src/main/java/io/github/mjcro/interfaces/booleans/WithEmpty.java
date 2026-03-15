package io.github.mjcro.interfaces.booleans;

/**
 * Mixin interface for objects that have an empty/non-empty state.
 */
public interface WithEmpty {
    /**
     * @return True if entity/collection is empty.
     */
    boolean isEmpty();

    /**
     * @return True if entity/collection is not empty.
     */
    default boolean isNotEmpty() {
        return !isEmpty();
    }
}
