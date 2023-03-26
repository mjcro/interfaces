package io.github.mjcro.interfaces.booleans;

public interface WithEnabled {
    /**
     * @return True if entity is marked as enabled.
     */
    boolean isEnabled();

    /**
     * @return True if entity is not marked as enabled.
     */
    default boolean isNotEnabled() {
        return !isEnabled();
    }

    /**
     * @return True if entity is not marked as enabled.
     */
    default boolean isDisabled() {
        return !isEnabled();
    }
}
