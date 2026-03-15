package io.github.mjcro.interfaces.longs;

/**
 * Convenience interface combining {@link StrongLong} and {@link WithId},
 * providing a default {@link #getId()} implementation that delegates to {@link #value()}.
 * Typical usage: {@code record UserId(long value) implements StrongLongId}.
 */
public interface StrongLongId extends StrongLong, WithId {
    @Override
    default long getId() {
        return value();
    }
}
