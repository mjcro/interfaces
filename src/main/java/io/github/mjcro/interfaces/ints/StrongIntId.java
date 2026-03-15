package io.github.mjcro.interfaces.ints;

/**
 * Convenience interface combining {@link StrongInt} and {@link WithId},
 * providing a default {@link #getId()} implementation that delegates to {@link #value()}.
 * Typical usage: {@code record ProductId(int value) implements StrongIntId}.
 */
public interface StrongIntId extends StrongInt, WithId {
    @Override
    default int getId() {
        return value();
    }
}
