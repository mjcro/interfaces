package io.github.mjcro.interfaces.booleans;

/**
 * Mixin interface for objects that expose a visible/hidden boolean flag.
 *
 * <p>Implement this interface on UI elements, menu entries, or content items
 * that can be shown or hidden at runtime. Two convenience negations are
 * provided: the domain-expressive {@link #isHidden()} and the symmetric
 * {@link #isNotVisible()}.
 */
public interface WithVisible {
    /**
     * Returns whether this object is in the visible state.
     *
     * @return {@code true} if the object is visible; {@code false} if it is hidden.
     */
    boolean isVisible();

    /**
     * Returns whether this object is in the hidden state.
     *
     * <p>This is a convenience negation of {@link #isVisible()}.
     *
     * @return {@code true} if the object is hidden; {@code false} if it is visible.
     */
    default boolean isHidden() {
        return !isVisible();
    }

    /**
     * Returns whether this object is <em>not</em> in the visible state.
     *
     * <p>Semantically equivalent to {@link #isHidden()}; provided as a
     * symmetric alternative to {@link #isVisible()}.
     *
     * @return {@code true} if the object is not visible; {@code false} if it is visible.
     */
    default boolean isNotVisible() {
        return !isVisible();
    }
}
