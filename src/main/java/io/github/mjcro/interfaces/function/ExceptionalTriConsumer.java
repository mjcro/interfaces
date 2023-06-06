package io.github.mjcro.interfaces.function;

import java.util.Objects;

@FunctionalInterface
public interface ExceptionalTriConsumer<A, B, C> {
    static <A, B, C> ExceptionalTriConsumer<A, B, C> fromTriConsumer(TriConsumer<A, B, C> triConsumer) {
        Objects.requireNonNull(triConsumer, "triConsumer");
        return triConsumer::accept;
    }

    void accept(A a, B b, C c) throws Exception;

    default ExceptionalTriConsumer<A, B, C> andThen(ExceptionalTriConsumer<? super A, ? super B, ? super C> after) {
        Objects.requireNonNull(after, "after");
        return (a, b, c) -> {
            this.accept(a, b, c);
            after.accept(a, b, c);
        };
    }

    default ExceptionalTriConsumer<A, B, C> andThen(TriConsumer<? super A, ? super B, ? super C> after) {
        Objects.requireNonNull(after, "after");
        return (a, b, c) -> {
            this.accept(a, b, c);
            after.accept(a, b, c);
        };
    }
}
