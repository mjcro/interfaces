package io.github.mjcro.interfaces.booleans;

public interface WithDeleted {
    /**
     * @return True if entity is marked as deleted.
     */
    boolean isDeleted();

    /**
     * @return True if entity is not marked as deleted.
     */
    default boolean isNotDeleted() {
        return !isDeleted();
    }
}
