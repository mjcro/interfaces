package io.github.mjcro.interfaces.function;

import java.util.Objects;

/**
 * Extension of {@link java.util.function.BiConsumer} design but with three arguments.
 */
@FunctionalInterface
public interface TriConsumer<A, B, C> {
    void accept(A a, B b, C c);

    default TriConsumer<A, B, C> andThen(TriConsumer<? super A, ? super B, ? super C> after) {
        Objects.requireNonNull(after, "after");
        return (a, b, c) -> {
            this.accept(a, b, c);
            after.accept(a, b, c);
        };
    }
}
