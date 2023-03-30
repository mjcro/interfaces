package io.github.mjcro.interfaces.booleans;

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
