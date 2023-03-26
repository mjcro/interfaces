package io.github.mjcro.interfaces.booleans;

public interface WithActive {
    /**
     * @return True if entity is marked as active.
     */
    boolean isActive();

    /**
     * @return True if entity is not marked as active.
     */
    default boolean isNotActive() {
        return !isActive();
    }
}
