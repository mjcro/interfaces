package io.github.mjcro.interfaces.builders;

/**
 * Combines {@link SelfTyped} and {@link Builder} to support fluent builder patterns
 * with method chaining and a terminal {@link #build()} step.
 *
 * @param <B> The concrete builder type.
 * @param <R> The type produced by this builder.
 */
public interface SelfTypedBuilder<B extends SelfTypedBuilder<B, R>, R> extends SelfTyped<B>, Builder<R> {
}
