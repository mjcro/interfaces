package io.github.mjcro.interfaces.builders;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for self-referencing types, enabling fluent API patterns.
 *
 * @param <T> The concrete self type.
 */
public interface SelfTyped<T extends SelfTyped<T>> {
    /**
     * @return Self instance.
     */
    @NonNull T self();
}
