package io.github.mjcro.interfaces.builders;

public interface SelfTyped<T extends SelfTyped<T>> {
    /**
     * @return Self instance.
     */
    T self();
}
