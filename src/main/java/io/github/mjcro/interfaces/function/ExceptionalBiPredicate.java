package io.github.mjcro.interfaces.function;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * Defines behavior like {@link BiPredicate} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalBiPredicate<T, U> {
    static <T, U> ExceptionalBiPredicate<T, U> fromBiPredicate(BiPredicate<T, U> biPredicate) {
        Objects.requireNonNull(biPredicate, "biPredicate");
        return biPredicate::test;
    }

    boolean test(T t, U u) throws Exception;

    default ExceptionalBiPredicate<T, U> and(ExceptionalBiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other, "other");
        return (t, u) -> this.test(t, u) && other.test(t, u);
    }

    default ExceptionalBiPredicate<T, U> and(BiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other, "other");
        return (t, u) -> this.test(t, u) && other.test(t, u);
    }

    default ExceptionalBiPredicate<T, U> negate() {
        return (t, u) -> !this.test(t, u);
    }

    default ExceptionalBiPredicate<T, U> or(ExceptionalBiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other, "other");
        return (t, u) -> this.test(t, u) || other.test(t, u);
    }

    default ExceptionalBiPredicate<T, U> or(BiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other, "other");
        return (t, u) -> this.test(t, u) || other.test(t, u);
    }
}
