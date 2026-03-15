package io.github.mjcro.interfaces.booleans;

/**
 * Mixin interface for entities that can be marked as active or inactive.
 */
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
