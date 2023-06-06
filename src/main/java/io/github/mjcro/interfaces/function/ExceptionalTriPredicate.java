package io.github.mjcro.interfaces.function;

import java.util.Objects;

/**
 * Defines behavior like {@link TriPredicate} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalTriPredicate<A, B, C> {
    boolean test(A a, B b, C c) throws Exception;

    default ExceptionalTriPredicate<A, B, C> and(ExceptionalTriPredicate<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other, "other");
        return (a, b, c) -> this.test(a, b, c) && other.test(a, b, c);
    }

    default ExceptionalTriPredicate<A, B, C> and(TriPredicate<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other, "other");
        return (a, b, c) -> this.test(a, b, c) && other.test(a, b, c);
    }

    default ExceptionalTriPredicate<A, B, C> negate() {
        return (a, b, c) -> !this.test(a, b, c);
    }

    default ExceptionalTriPredicate<A, B, C> or(ExceptionalTriPredicate<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other, "other");
        return (a, b, c) -> this.test(a, b, c) || other.test(a, b, c);
    }

    default ExceptionalTriPredicate<A, B, C> or(TriPredicate<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other, "other");
        return (a, b, c) -> this.test(a, b, c) || other.test(a, b, c);
    }
}
