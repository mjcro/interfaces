package io.github.mjcro.interfaces.booleans;

/**
 * Mixin interface for objects that expose an active/inactive boolean flag.
 *
 * <p>Implement this interface on any entity or value object that carries an
 * activation state, e.g. user accounts, subscriptions, or feature flags.
 * The convenience method {@link #isNotActive()} is provided so callers do
 * not need to negate the primary accessor themselves.
 */
public interface WithActive {
    /**
     * Returns whether this object is in the active state.
     *
     * @return {@code true} if the object is active; {@code false} otherwise.
     */
    boolean isActive();

    /**
     * Returns whether this object is <em>not</em> in the active state.
     *
     * <p>This is a convenience negation of {@link #isActive()}.
     *
     * @return {@code true} if the object is inactive; {@code false} if it is active.
     */
    default boolean isNotActive() {
        return !isActive();
    }
}
