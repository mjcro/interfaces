package io.github.mjcro.interfaces;

import org.jspecify.annotations.NonNull;


/**
 * Generic interface for decorators.
 *
 * @param <T> The type being decorated.
 */
public interface Decorator<T> {
    /**
     * @return Object being decorated.
     */
    @NonNull T getDecorated();

    /**
     * @return Object being decorated, recursively unwrapped if it is also a decorator.
     */
    @SuppressWarnings("unchecked")
    default @NonNull T getDecoratedRoot() {
        T decorated = getDecorated();
        if (decorated instanceof Decorator<?>) {
            return ((Decorator<T>) decorated).getDecoratedRoot();
        }
        return decorated;
    }
}
