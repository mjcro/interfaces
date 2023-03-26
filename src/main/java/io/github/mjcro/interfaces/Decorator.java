package io.github.mjcro.interfaces;

/**
 * Generic interface for decorators.
 */
public interface Decorator<T> {
    /**
     * @return Object been decorated.
     */
    T getDecorated();

    /**
     * @return Objects been decorated, recursively, if it's also a decorator.
     */
    @SuppressWarnings("unchecked")
    default T getDecoratedRoot() {
        T decorated = getDecorated();
        if (decorated instanceof Decorator<?>) {
            return ((Decorator<T>) decorated).getDecoratedRoot();
        }
        return decorated;
    }
}
