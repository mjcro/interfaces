package io.github.mjcro.interfaces.function;

import java.util.Objects;

@FunctionalInterface
public interface TriPredicate<A, B, C> {
    boolean test(A a, B b, C c);

    default TriPredicate<A, B, C> and(TriPredicate<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other, "other");
        return (a, b, c) -> this.test(a, b, c) && other.test(a, b, c);
    }

    default TriPredicate<A, B, C> negate() {
        return (a, b, c) -> !this.test(a, b, c);
    }

    default TriPredicate<A, B, C> or(TriPredicate<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other, "other");
        return (a, b, c) -> this.test(a, b, c) || other.test(a, b, c);
    }
}
