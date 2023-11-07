package io.github.mjcro.interfaces.builders;

public interface SelfTypedBuilder<B extends SelfTypedBuilder<B, R>, R> extends SelfTyped<B>, Builder<R> {
}
