package io.github.mjcro.interfaces.booleans;

/**
 * Mixin interface for objects that expose an enabled/disabled boolean flag.
 *
 * <p>Implement this interface on entities such as plugins, integrations, or
 * configuration entries that can be switched on or off. Two convenience
 * negations are provided: {@link #isNotEnabled()} for symmetry with the
 * primary accessor, and the more expressive {@link #isDisabled()} for
 * readability in domain-specific contexts.
 */
public interface WithEnabled {
    /**
     * Returns whether this object is in the enabled state.
     *
     * @return {@code true} if the object is enabled; {@code false} otherwise.
     */
    boolean isEnabled();

    /**
     * Returns whether this object is <em>not</em> in the enabled state.
     *
     * <p>This is a convenience negation of {@link #isEnabled()}.
     *
     * @return {@code true} if the object is not enabled; {@code false} if it is enabled.
     */
    default boolean isNotEnabled() {
        return !isEnabled();
    }

    /**
     * Returns whether this object is in the disabled state.
     *
     * <p>Semantically equivalent to {@link #isNotEnabled()}; provided as a
     * more expressive alternative.
     *
     * @return {@code true} if the object is disabled; {@code false} if it is enabled.
     */
    default boolean isDisabled() {
        return !isEnabled();
    }
}
