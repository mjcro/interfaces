package io.github.mjcro.interfaces.function;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Defines behavior like {@link Predicate} but able to throw checked exception.
 */
@FunctionalInterface
public interface ExceptionalPredicate<T> {
    static <T> ExceptionalPredicate<T> fromPredicate(Predicate<T> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return predicate::test;
    }

    boolean test(T t) throws Exception;

    default ExceptionalPredicate<T> and(ExceptionalPredicate<? super T> other) {
        Objects.requireNonNull(other, "other");
        return (t) -> this.test(t) && other.test(t);
    }

    default ExceptionalPredicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other, "other");
        return (t) -> this.test(t) && other.test(t);
    }

    default ExceptionalPredicate<T> negate() {
        return (t) -> !this.test(t);
    }

    default ExceptionalPredicate<T> or(ExceptionalPredicate<? super T> other) {
        Objects.requireNonNull(other, "other");
        return (t) -> this.test(t) || other.test(t);
    }

    default ExceptionalPredicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other, "other");
        return (t) -> this.test(t) || other.test(t);
    }
}
