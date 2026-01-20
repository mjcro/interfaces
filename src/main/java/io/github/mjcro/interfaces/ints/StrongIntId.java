package io.github.mjcro.interfaces.ints;

public interface StrongIntId extends StrongInt, WithId {
    @Override
    default int getId() {
        return value();
    }
}
