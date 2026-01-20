package io.github.mjcro.interfaces.longs;

public interface StrongLongId extends StrongLong, WithId {
    @Override
    default long getId() {
        return value();
    }
}
