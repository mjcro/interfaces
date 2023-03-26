package io.github.mjcro.interfaces.booleans;

public interface WithVisible {
    /**
     * @return True if entity is marked as visible.
     */
    boolean isVisible();

    /**
     * @return True if entity is not marked as visible.
     */
    default boolean isHidden() {
        return !isVisible();
    }

    /**
     * @return True if entity is not marked as visible.
     */
    default boolean isNotVisible() {
        return !isVisible();
    }
}
