package io.github.mjcro.interfaces.builders;

/**
 * Mixin interface for self-referencing types, enabling fluent API patterns.
 *
 * @param <T> The concrete self type.
 */
public interface SelfTyped<T extends SelfTyped<T>> {
    /**
     * @return Self instance.
     */
    T self();
}
